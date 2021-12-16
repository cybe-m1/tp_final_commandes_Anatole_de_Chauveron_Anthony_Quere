package com.fges.commandes.commandes.authentication;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "authentication")
@Getter
@Setter
public class AuthenticationConfig {
    private UserDefinition admin;
    private UserDefinition user;
}
