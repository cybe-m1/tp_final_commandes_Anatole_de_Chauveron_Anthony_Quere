package com.fges.commandes.commandes.truck;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TruckNotFoundException extends Exception {
    public TruckNotFoundException() {
    }

    public TruckNotFoundException(String message) {
        super(message);
    }
}
