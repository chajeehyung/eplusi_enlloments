package dk.eplusi.dev.enrollments.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    //    @Value("${http.port}")
//    private int httpPort;
//    @Value("${server.port}")
//    private int httpsPort;
    public static final String LOGOUT_SUCCESS_URL = "/login?logout";

    private final AccessDeniedHandler ACCESS_DENIED_HANDLER;
    private final AuthenticationSuccessHandler AUTHENTICATION_SUCCESS_HANDLER;
    private final AuthenticationFailureHandler AUTHENTICATION_FAILURE_HANDLER;

    @Autowired
    public SpringSecurityConfig(AccessDeniedHandler ACCESS_DENIED_HANDLER, AuthenticationSuccessHandler AUTHENTICATION_SUCCESS_HANDLER, AuthenticationFailureHandler AUTHENTICATION_FAILURE_HANDLER) {
        super();
        this.ACCESS_DENIED_HANDLER = ACCESS_DENIED_HANDLER;
        this.AUTHENTICATION_SUCCESS_HANDLER = AUTHENTICATION_SUCCESS_HANDLER;
        this.AUTHENTICATION_FAILURE_HANDLER = AUTHENTICATION_FAILURE_HANDLER;
    }

    public void configure(WebSecurity webSecurity) throws Exception {
        webSecurity.ignoring().antMatchers("/resources/**", "/css/**", "/fonts/**", "/js/**", "/less/**", "/scss/**", "/images/**", "/webjars/**");
        webSecurity.httpFirewall(allowUrlEncodedSlashHttpFirewall());
    }

    /**
     * customize firewall
     * @return custom firewall
     */
    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true);
        firewall.setAllowSemicolon(true);
        return firewall;
    }

    // custom custom403.html access denied handler
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                //port for HTTP / HTTPS
//                .portMapper()
//                .http(httpPort).mapsTo(httpsPort)
//                .and()
                //CSRF setting
                .csrf()
                .and()
                //authorization for requests
                .authorizeRequests()
                /*.antMatchers("/admin/**").hasAnyRole("ADMIN")*/   //intentionally expose admin page.
//                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                //header options
                .headers()
                .frameOptions().disable()
                .and()
//                //SSL
//                .requiresChannel()
//                .antMatchers("/login*").requiresSecure()
//                .anyRequest().requiresInsecure()
//                .and()
                //session
                .sessionManagement()
                .sessionFixation().none()
                .and()
                //login & logout
                .formLogin()
                .loginPage("/login")
                .successHandler(AUTHENTICATION_SUCCESS_HANDLER)
                .failureHandler(AUTHENTICATION_FAILURE_HANDLER)
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl(LOGOUT_SUCCESS_URL)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
                //error handlers
                .exceptionHandling().accessDeniedHandler(ACCESS_DENIED_HANDLER);

    }

    // create two users, admin and user
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}user").roles("USER")
                .and()
                .withUser("admin").password("{noop}admin").roles("ADMIN");
    }
}