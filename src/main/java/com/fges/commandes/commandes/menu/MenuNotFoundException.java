package com.fges.commandes.commandes.menu;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MenuNotFoundException extends Exception {

    public MenuNotFoundException() {
    }

    public MenuNotFoundException(String message) {
        super(message);
    }
}
