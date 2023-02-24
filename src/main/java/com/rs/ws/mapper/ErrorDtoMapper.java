package com.rs.ws.mapper;

import com.rs.ws.dto.errorDto.ErrorDTo;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

@UtilityClass
public class ErrorDtoMapper {
    public static ErrorDTo mapperDtoError (String n){
        return ErrorDTo.builder()
                .msg(n)
                .httpStatus(HttpStatus.NOT_FOUND)
                .statusCode(HttpStatus.NO_CONTENT.value())
                .build();
    }
}
