package com.rs.ws.exception.handler;

import com.rs.ws.dto.errorDto.ErrorDTo;
import com.rs.ws.exception.BadRequest;
import com.rs.ws.exception.BusinessException;
import com.rs.ws.exception.NotFoundException;
import com.rs.ws.mapper.ErrorDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;

@RestControllerAdvice
public class ResourceHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTo> notFoundException(NotFoundException n){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorDtoMapper.mapperDtoError(n.getMessage()));

    }
    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<ErrorDTo> badRequest (BusinessException b){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDtoMapper.mapperDtoError(b.getMessage()));
    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorDTo> badRequest (BadRequest b){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorDTo.builder()
                        .msg(b.getMessage())
                        .statusCode(HttpStatus.CONFLICT.value())
                        .httpStatus(HttpStatus.CONFLICT)
                .build());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTo> badRequest (MethodArgumentNotValidException m){

        HashMap<String, String> messages = new HashMap<>();
        m.getBindingResult().getAllErrors().forEach(error ->{
           String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            messages.put(field,message);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDtoMapper.mapperDtoError(Arrays.toString(messages.entrySet().toArray())));
    }
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorDTo> notFoundException(SQLException d){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorDtoMapper.mapperDtoError(d.getMessage()));

    }
}
