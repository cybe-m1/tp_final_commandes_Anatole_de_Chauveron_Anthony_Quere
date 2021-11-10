package com.fges.commandes.commandes.dish;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DishNotFoundException extends Exception {
    public DishNotFoundException() {
    }

    public DishNotFoundException(String message) {
        super(message);
    }
}