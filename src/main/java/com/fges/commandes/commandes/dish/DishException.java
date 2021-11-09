package com.fges.commandes.commandes.dish;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DishException extends Exception{
    public DishException() {
    }

    public DishException(String message) {
        super(message);
    }
}