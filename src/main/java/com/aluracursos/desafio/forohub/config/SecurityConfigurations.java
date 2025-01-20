package com.aluracursos.desafio.forohub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfigurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Deshabilitar CSRF (solo para pruebas iniciales)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/topicos/**").authenticated() // Rutas protegidas
                        .anyRequest().permitAll() // Rutas públicas
                )
                .httpBasic(withDefaults()) // Configuración básica para pruebas
                .formLogin(form -> form
                        .loginPage("/login") // Configura una página de inicio de sesión personalizada si tienes una
                        .defaultSuccessUrl("/topicos", true) // Redirige después del inicio de sesión exitoso
                );
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
