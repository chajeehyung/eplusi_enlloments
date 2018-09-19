package dk.eplusi.dev.enrollments.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomLogoutSuccessHandler.class);

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        LOGGER.info("Log out success: (host=" + httpServletRequest.getRemoteHost() + ", user=" + httpServletRequest.getRemoteUser() + ", auth=" + authentication.toString() + ")");
    }
}
