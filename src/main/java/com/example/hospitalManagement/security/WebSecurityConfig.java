package com.example.hospitalManagement.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {
//    private  final PasswordEncoder passwordEncoder;
private final JwtAuthFilter jwtAuthFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity


                .csrf(csrfConfig -> csrfConfig.disable())
                .sessionManagement(sessionConfig ->
                        sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // in the above 2 statements we disable the default browser sessions

                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll()
                                .requestMatchers("/auth/**").permitAll()
//                .requestMatchers("/admin/**").authenticated()
//                .requestMatchers("/admin/**").hasRole("ADMIN")
//                .requestMatchers("/doctors/**").hasAnyRole("DOCTOR", "ADMIN")
//                                .anyRequest().permitAll()
                                .anyRequest().authenticated()
                )
                // add the filter in the chain
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
                //.formLogin(Customizer.withDefaults()); //comment as we donot want default sing up form
        return  httpSecurity.build();
    }

//    @Bean
//    UserDetailsService userDetailsService() {
//        UserDetails user1 = User.withUsername("admin")
//                .password(passwordEncoder.encode("pass"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user2 = User.withUsername("patient")
//                .password(passwordEncoder.encode("pass"))
//                .roles("PATIENT")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, user2);
//    }
}
