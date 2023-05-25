package com.mainproject.global.config;

import com.mainproject.global.security.auth.filter.JwtAuthenticationFilter;
import com.mainproject.global.security.auth.filter.JwtVerificationFilter;
import com.mainproject.global.security.auth.handler.MemberAccessDeniedHandler;
import com.mainproject.global.security.auth.handler.MemberAuthenticationEntryPoint;
import com.mainproject.global.security.auth.handler.MemberAuthenticationFailureHandler;
import com.mainproject.global.security.auth.handler.MemberAuthenticationSuccessHandler;
import com.mainproject.global.security.auth.jwt.JwtTokenizer;
import com.mainproject.global.security.auth.userdetails.MemberDetailsService;
import com.mainproject.global.security.auth.utils.CustomAuthorityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.*;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
    private final JwtTokenizer jwtTokenizer;
    private final CustomAuthorityUtils authorityUtils;
    private final MemberDetailsService memberDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // HttpSecurity를 통해 HTTP 요청에 대한 보안 설정을 구성한다.
        http
                .headers().frameOptions().sameOrigin()
                .and()
                .csrf().disable()
                .cors(withDefaults())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .exceptionHandling()
                .authenticationEntryPoint(new MemberAuthenticationEntryPoint())
                .accessDeniedHandler(new MemberAccessDeniedHandler())
                .and()
                .apply(new CustomFilterConfigurer())
                .and()
                .authorizeHttpRequests(auth -> auth
                        .antMatchers("/").hasRole("ADMIN")
                        .antMatchers("/").hasRole("USER")
                        .antMatchers("/**").permitAll() // 앞에서 지정한 URL 이외의 나머지 모든 URL은 Role에 상관없이 접근이 가능함
                );

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public class CustomFilterConfigurer extends AbstractHttpConfigurer<CustomFilterConfigurer, HttpSecurity> {
        @Override
        public void configure(HttpSecurity builder) throws Exception {
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);

            JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager, jwtTokenizer);
            jwtAuthenticationFilter.setFilterProcessesUrl("/api/members/login");

            jwtAuthenticationFilter.setAuthenticationSuccessHandler(new MemberAuthenticationSuccessHandler());
            jwtAuthenticationFilter.setAuthenticationFailureHandler(new MemberAuthenticationFailureHandler());

            JwtVerificationFilter jwtVerificationFilter = new JwtVerificationFilter(jwtTokenizer, authorityUtils);

            builder.addFilter(jwtAuthenticationFilter)
                    .addFilterAfter(jwtVerificationFilter, JwtAuthenticationFilter.class);
        }
    }


}
