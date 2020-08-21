package com.ficticiusclean.fluig.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -947329752066018828L;

    public BusinessException(String message) {
        super(message);
    }
}
