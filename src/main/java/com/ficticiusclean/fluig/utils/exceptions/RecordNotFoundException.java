package com.ficticiusclean.fluig.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -8571893033346179789L;

    public RecordNotFoundException(String message) {
        super(message);
    }
}
