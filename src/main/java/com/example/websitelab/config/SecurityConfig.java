package com.example.websitelab.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder passwordEncoder = passwordEncoder();

        UserDetails user = User.withUsername("Admin")
                .password(passwordEncoder.encode("yourEncodedPassword"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                .authorizeHttpRequests((authorizeExchange) -> authorizeExchange
                        .requestMatchers("/client/**").permitAll()
                        .requestMatchers("/intern/**","/reviews/**").permitAll()
                        .requestMatchers("/swagger-ui.html/**", "/swagger-ui/**", "/v3/api-docs/**").hasRole("ADMIN")
                        .requestMatchers("/admin/").hasRole("ADMIN")
                        .anyRequest().hasRole("ADMIN"))
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .addFilterBefore(corsFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    @Bean
    public CorsFilter corsFilter() {
        CorsConfigurationSource source = request -> {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedOrigins(Arrays.asList("*"));
            config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
            config.setAllowedHeaders(Arrays.asList("Origin", "X-Requested-With", "Content-Type", "Accept"));
            return config;
        };

        return new CorsFilter(source);
    }
}

