package com.rs.ws.service.impl;

import com.rs.ws.dto.JWTdto;
import com.rs.ws.dto.LoginDto;
import com.rs.ws.service.AutenticationService;
import com.rs.ws.service.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AutenticationServiceImpl implements AutenticationService {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AutenticationServiceImpl(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @Override
    public JWTdto auth(LoginDto dto) {
        UsernamePasswordAuthenticationToken userPassAuth = new
                UsernamePasswordAuthenticationToken(dto.getUsername(),dto.getPassword());

        Authentication auth = authenticationManager.authenticate(userPassAuth);
        String token = tokenService.getToken(auth);
        return JWTdto.builder()
                .type("Bearer")
                .token(token)
                .build();
    }
}
