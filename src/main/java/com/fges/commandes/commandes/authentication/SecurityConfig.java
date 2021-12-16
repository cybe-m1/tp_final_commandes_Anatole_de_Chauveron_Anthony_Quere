package com.fges.commandes.commandes.authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationConfig authenticationConfig;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(User.withUsername(authenticationConfig.getAdmin().getUsername()).password(passwordEncoder().encode(authenticationConfig.getAdmin().getPassword())).roles("ADMIN", "USER"))
                .withUser(User.withUsername(authenticationConfig.getUser().getUsername()).password(passwordEncoder().encode(authenticationConfig.getUser().getPassword())).roles("USER"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // H2 cosole should be available to all users
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/**").hasAnyRole("ADMIN", "USER")
                .anyRequest().hasRole("ADMIN")
                .and()
                .httpBasic()
                .and()
                .csrf().disable();

    }
}
