/*
package com.targetsolutions.iurydev.crud_application.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig implements WebMvcConfigurer {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf ->csrf.disable())
                .authorizeHttpRequests((request) -> request
                        .requestMatchers(HttpMethod.POST, "/user/**").permitAll()
                        .anyRequest()
                        .authenticated());

        return http.build();

    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite CORS para todas as rotas
                .allowedOrigins("http://localhost:8080/tarefa") // Substitua com o domínio do seu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*"); // Permite todos os cabeçalhos
    }
}  */
