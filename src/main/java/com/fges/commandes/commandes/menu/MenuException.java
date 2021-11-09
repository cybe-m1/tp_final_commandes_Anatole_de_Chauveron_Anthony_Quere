package com.fges.commandes.commandes.menu;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MenuException extends Exception {

    public MenuException() {
    }

    public MenuException(String message) {
        super(message);
    }
}
