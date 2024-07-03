package com.quynhtd.source_code_final.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SpringSocialConfigurer;

import com.quynhtd.source_code_final.entity.AppRole;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        // Pages do not require login
        http.authorizeRequests().antMatchers( "/register", "/login", "/logout","/static/**","/i18n/**").permitAll();

        http.authorizeRequests().antMatchers("/userInfo", "/store/**").access("hasRole('" + AppRole.ROLE_USER + "')");

        // For ADMIN only.
        http.authorizeRequests().antMatchers("/admin", "/store/**").access("hasRole('" + AppRole.ROLE_ADMIN + "')");

        // When the user has logged in as XX.
        // But access a page that requires role YY,
        // AccessDeniedException will be thrown.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/405");

        // Form Login config
        http.authorizeRequests().and().formLogin()//
                // Submit URL of login page.
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/index")//
                .failureUrl("/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password");

        // Logout Config
        http.authorizeRequests().and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");

        // Spring Social Config.
        http.apply(new SpringSocialConfigurer())
                //
                .signupUrl("/register");

    }

    // This bean is load the user specific data when form login is used.
    @Override
    public UserDetailsService userDetailsService() {
        return userDetailsService;
    }

}

