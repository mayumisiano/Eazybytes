package com.eazybytes.springsecuritybasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests()
                .requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
                        .requestMatchers("/notices","/contact").permitAll()
                        .and().formLogin()
                        .and().httpBasic();
        http.formLogin();
        http.httpBasic();
        return http.build();

        /* Configuration to deny all the requests */

//        http.authorizeHttpRequests().anyRequest().denyAll()
//                        .and().formLogin()
//                        .and().httpBasic();
//        http.formLogin();
//        http.httpBasic();
//        return http.build();

        /* Configuration to permit all the requests */

//        http.authorizeHttpRequests().anyRequest().permitAll()
//                .and().formLogin()
//                .and().httpBasic();
//        http.formLogin();
//        http.httpBasic();
//        return http.build();

    }
}
