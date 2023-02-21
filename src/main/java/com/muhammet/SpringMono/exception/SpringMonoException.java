package com.muhammet.SpringMono.exception;

import lombok.Getter;

@Getter
public class SpringMonoException extends RuntimeException{
    private final ErrorType errorType;

    /**
     * Runtime dan miras aldığımız için hata mesajının kendisine iletilmesi gereklidir.
     * @param errorType
     */
    public SpringMonoException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType= errorType;
    }

    public SpringMonoException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }
}
