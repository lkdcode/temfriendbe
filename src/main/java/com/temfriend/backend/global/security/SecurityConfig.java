package com.temfriend.backend.global.security;

import com.temfriend.backend.global.jwt.JWTProvider;
import com.temfriend.backend.global.jwt.filter.JWTAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    public static final String[] PUBLIC = new String[]{
            "/h2-console/**"
    };

    public static final String[] GET_PUBLIC = new String[]{
            "/${api.users}/**"
    };

    public static final String[] POST_PUBLIC = new String[]{
            "/${api.users}/sign-up"
            , "/${api.users}/sign-in"
    };

    private final JWTProvider jwtProvider;

    @Autowired
    private Environment environment;

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();

        return http.httpBasic()
                .disable()
                .csrf().disable()
                .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeRequests(auth ->
                        auth
                                .antMatchers(HttpMethod.GET, GET_PUBLIC).permitAll()
                                .antMatchers(HttpMethod.POST, POST_PUBLIC).permitAll()
                                .antMatchers(PUBLIC).permitAll()
                                .antMatchers("/api/admin/**").hasRole("ADMIN")
                                .antMatchers("/api/user/**").hasRole("USER")
                                .anyRequest().authenticated())
                .addFilterBefore(
                        new JWTAuthenticationFilter(jwtProvider),
                        UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}