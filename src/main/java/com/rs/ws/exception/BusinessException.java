package com.rs.ws.exception;


public class BusinessException extends RuntimeException{

    public BusinessException(String msg){
        super(msg);
    }
}
