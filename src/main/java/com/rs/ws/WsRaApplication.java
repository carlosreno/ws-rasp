package com.rs.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class WsRaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsRaApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("qwe123"));
    }

}
