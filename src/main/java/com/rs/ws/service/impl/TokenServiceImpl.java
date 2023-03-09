package com.rs.ws.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.rs.ws.model.UserCredential;
import com.rs.ws.service.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {
    @Value("${webservice.algorithm.secret}")
    private String secret;
    @Override
    public String getToken(Authentication authentication) {
       UserCredential userCredential = (UserCredential) authentication.getPrincipal();
        Date today = new Date();
        Date expiretionDate = new Date(today.getTime()+3600000);
        return JWT.create()
                .withIssuer("Api rasmoo")
                .withSubject(userCredential.getUsername())
                .withIssuedAt(today)
                .withExpiresAt(expiretionDate)
                .sign(Algorithm.HMAC256(secret));
    }

    @Override
    public Boolean isValid(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withIssuer("Bearer")
                // reusable verifier instance
                .build();

        DecodedJWT decodedJWT = verifier.verify(token);
        return true;
    }

}
