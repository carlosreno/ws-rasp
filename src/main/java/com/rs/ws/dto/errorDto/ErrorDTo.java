package com.rs.ws.dto.errorDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTo {

    private String msg;
    private HttpStatus httpStatus;
    private Integer statusCode;
}
