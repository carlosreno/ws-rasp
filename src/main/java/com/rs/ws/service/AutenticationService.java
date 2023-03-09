package com.rs.ws.service;

import com.rs.ws.dto.JWTdto;
import com.rs.ws.dto.LoginDto;

public interface AutenticationService {
    JWTdto auth(LoginDto dto);
}
