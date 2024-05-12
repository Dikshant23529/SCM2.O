package com.scm.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.scm.services.SecurityUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private SecurityUserDetailService securityUserDetailService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(securityUserDetailService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // http.csrf((csrf) -> csrf.disable())
        //         .authorizeHttpRequests((auth) -> auth.requestMatchers("/signup", "/registeruser").permitAll()
        //                 .anyRequest().authenticated())
        //         .formLogin(Customizer.withDefaults());

        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/user/").authenticated();
            auth.anyRequest().permitAll();
        }).formLogin(formlogin -> {
            formlogin.loginPage("/login");
            formlogin.loginProcessingUrl("/autherization");
            formlogin.successForwardUrl("/user/");
            formlogin.failureForwardUrl("/login?error=true");
            formlogin.usernameParameter("email");
            formlogin.passwordParameter("password");
        }).logout((logout) -> {
            logout.logoutUrl("/logout");
        });

        // .csrf(csrf -> {
        //     csrf.disable();
        // })

        return http.build();
    }

}
