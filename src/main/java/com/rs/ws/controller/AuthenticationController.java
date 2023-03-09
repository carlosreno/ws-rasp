package com.rs.ws.controller;

import com.rs.ws.dto.JWTdto;
import com.rs.ws.dto.LoginDto;
import com.rs.ws.service.AutenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AutenticationService autenticationService;
    AuthenticationController(AutenticationService autenticationService){
        this.autenticationService = autenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<JWTdto> auth(@Valid @RequestBody LoginDto dto){

        return ResponseEntity.status(HttpStatus.OK).body(autenticationService.auth(dto));
    }
}
