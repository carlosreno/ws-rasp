package com.rs.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EntityScan(basePackages = {"com.rs.ws.model"})
@SpringBootApplication
public class WsRaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsRaApplication.class, args);
    }

}
