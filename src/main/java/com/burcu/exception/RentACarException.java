package com.burcu.exception;

import lombok.Getter;

@Getter
public class RentACarException extends RuntimeException {

    private final ErrorType errorType;

    public RentACarException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public RentACarException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }


}
