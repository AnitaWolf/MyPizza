package com.example.mypizza.config;


import com.example.mypizza.jwt.JwtAuthFilter;
import com.example.mypizza.model.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthFilter authFilter;

    // User Creation
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserInfoService();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/auth/welcome", "/auth/addNewUser", "/auth/generateToken").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/auth/user/**").hasAuthority("user")
                .and()
                .authorizeHttpRequests().requestMatchers("/auth/admin/**").hasAuthority("admin")
                .and()
                .authorizeHttpRequests().requestMatchers("/pizzas/user/**").hasAuthority("user")
                .and()
                .authorizeHttpRequests().requestMatchers("/cafes/user/**").hasAuthority("user")
                .and()
                .authorizeHttpRequests().requestMatchers("/pizzas/admin/**").hasAuthority("admin")
                .and()
                .authorizeHttpRequests().requestMatchers("/cafes/admin/**").hasAuthority("admin")
                .and()
                .authorizeHttpRequests().requestMatchers("/orders/**").hasAuthority("admin")
                .and()
                .authorizeHttpRequests().requestMatchers("/customers/**").hasAuthority("admin")
                .and()
//                .authorizeHttpRequests().requestMatchers(HttpMethod.DELETE,"/pizzas/**").hasAuthority("admin")
//                .and()
//                .authorizeHttpRequests().requestMatchers(HttpMethod.DELETE,"/cafes/**").hasAuthority("admin")
//                .and()
//                .authorizeHttpRequests().requestMatchers(HttpMethod.DELETE,"/customers/**").hasAuthority("admin")
//                .and()
//                .authorizeHttpRequests().requestMatchers(HttpMethod.DELETE,"/orders/**").hasAuthority("admin")
//                .and()
//                .authorizeHttpRequests().requestMatchers(HttpMethod.PUT,"/pizzas/**").hasAuthority("admin")
//                .and()
//                .authorizeHttpRequests().requestMatchers(HttpMethod.PUT,"/cafes/**").hasAuthority("admin")
//                .and()
//                .authorizeHttpRequests().requestMatchers(HttpMethod.PUT,"/customers/**").hasAuthority("admin")
//                .and()
//                .authorizeHttpRequests().requestMatchers(HttpMethod.PUT,"/orders/**").hasAuthority("admin")
//                .and()
//                .authorizeHttpRequests().requestMatchers(HttpMethod.POST,"/pizzas/**").hasAuthority("admin")
//                .and()
//                .authorizeHttpRequests().requestMatchers(HttpMethod.POST,"/cafes/**").hasAuthority("admin")
//                .and()
//                .authorizeHttpRequests().requestMatchers(HttpMethod.POST,"/customers/**").hasAuthority("admin")
//                .and()
//                .authorizeHttpRequests().requestMatchers(HttpMethod.POST,"/orders/**").hasAuthority("admin")
                //.and()
//                .authorizeHttpRequests().requestMatchers("/**").hasAuthority("admin")
//                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }





    // Password Encoding
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}

