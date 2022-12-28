package com.g3c1.aidboss.global.security.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.g3c1.aidboss.global.security.exception.CustomAuthenticationEntryPoint
import com.g3c1.aidboss.global.security.filter.ExceptionFilter
import com.g3c1.aidboss.global.security.filter.JwtTokenFilter
import com.g3c1.aidboss.global.security.jwt.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsUtils


@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtTokenProvider: JwtTokenProvider,
    private val objectMapper: ObjectMapper,
) {

    @Bean
    fun filterChain(http: HttpSecurity):SecurityFilterChain {
        http
            .csrf().disable()
            .formLogin().disable()
            .cors().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
            .antMatchers(HttpMethod.POST,"/api/v2/user").permitAll()
            .antMatchers(HttpMethod.POST,"/api/v2/user/**").permitAll()
            .antMatchers(HttpMethod.PATCH,"/api/v2/user").permitAll()
            .antMatchers(HttpMethod.POST,"api/v2/image").permitAll()
            .anyRequest().authenticated()
            .and()
            .exceptionHandling().authenticationEntryPoint(CustomAuthenticationEntryPoint(objectMapper))
            .and()
            .addFilterAfter(JwtTokenFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter::class.java)
            .addFilterBefore(ExceptionFilter(objectMapper), UsernamePasswordAuthenticationFilter::class.java)
        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder? = BCryptPasswordEncoder()
}