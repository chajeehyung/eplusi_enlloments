package dk.eplusi.dev.enrollments.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

    private RequestCache requestCache = new HttpSessionRequestCache();
    private String targetUrlParameter;
    private String defaultUrl;
    private boolean useReferer;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public CustomAuthenticationSuccessHandler() {
        targetUrlParameter = "";
        defaultUrl = "/";
        useReferer = false;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        clearAuthenticationAttributes(request);

        SavedRequest savedRequest = requestCache.getRequest(request, response);
        String targetUrl = defaultUrl;
        switch(decideRedirectStrategy(request, response)) {
            case 1:
                if(savedRequest != null)
                    requestCache.removeRequest(request, response);

                targetUrl = request.getParameter(targetUrlParameter);
                break;
            case 2:
                targetUrl = savedRequest.getRedirectUrl();
                break;
            case 3:
                targetUrl = request.getHeader("REFERER");
                break;
        }
        //if redirect target url is logout success url, just redirect main page.
        String rootPath = request.getRequestURL().substring(0, request.getRequestURL().indexOf(request.getRequestURI()));
        if(targetUrl.equals(rootPath + SpringSecurityConfig.LOGOUT_SUCCESS_URL))
            targetUrl = defaultUrl;
        redirectStrategy.sendRedirect(request, response, targetUrl);

        LOGGER.info("Authentication success: " + authentication.getName());
    }

    private void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            return;
        }

        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    /**
     * 인증 성공후 어떤 URL로 redirect 할지를 결정한다
     * 판단 기준은 targetUrlParameter 값을 읽은 URL이 존재할 경우 그것을 1순위
     * 1순위 URL이 없을 경우 Spring Security가 세션에 저장한 URL을 2순위
     * 2순위 URL이 없을 경우 Request의 REFERER를 사용하고 그 REFERER URL이 존재할 경우 그 URL을 3순위
     * 3순위 URL이 없을 경우 Default URL을 4순위로 한다
     * @param request
     * @param response
     * @return   1 : targetUrlParameter 값을 읽은 URL
     *            2 : Session에 저장되어 있는 URL
     *            3 : referer 헤더에 있는 url
     *            0 : default url
     */
    private int decideRedirectStrategy(HttpServletRequest request, HttpServletResponse response) {
        int result = 0;

        SavedRequest savedRequest = requestCache.getRequest(request, response);

        if(!"".equals(targetUrlParameter)) {
            String targetUrl = request.getParameter(targetUrlParameter);
            if(StringUtils.hasText(targetUrl)) {
                result = 1;
            } else {
                if(savedRequest != null) {
                    result = 2;
                } else {
                    String refererUrl = request.getHeader("REFERER");
                    if(useReferer && StringUtils.hasText(refererUrl)) {
                        result = 3;
                    } else {
                        result = 0;
                    }
                }
            }

            return result;
        }

        if(savedRequest != null) {
            result = 2;
            return result;
        }

        String refererUrl = request.getHeader("REFERER");
        if(useReferer && StringUtils.hasText(refererUrl))
            result = 3;


        return result;
    }
}

