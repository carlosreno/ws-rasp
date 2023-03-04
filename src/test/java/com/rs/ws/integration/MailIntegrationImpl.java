package com.rs.ws.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MailIntegrationImpl {
    @Autowired
    private MailIntegration mailIntegration;

    @Test
    void createCostumer(){
        mailIntegration.sendMail("carlosdavi090787@gmail.com","Salve mane","salve");
    }
}
