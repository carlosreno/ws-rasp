package com.rs.ws.integration;


import com.rs.ws.dto.wsraspay.CreditCardDto;
import com.rs.ws.dto.wsraspay.CustomerDto;
import com.rs.ws.dto.wsraspay.OrderDto;
import com.rs.ws.dto.wsraspay.PayentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class wsRaspayIntegrationImpl {

    @Autowired
    private WsRaspayIntegration wsRaspayIntegration;
    @Test
    void createCustomerDto(){
        CustomerDto customerDto = new CustomerDto(null,"08142678314","teste@teste","davizao","alves");
        wsRaspayIntegration.createCustomer(customerDto);
    }
    @Test
    void createOrder(){
        OrderDto orderDto = new OrderDto(null,"64035fc04022d11268fe63b6", BigDecimal.ZERO,"MES2022");
        wsRaspayIntegration.createOrder(orderDto);
    }
    @Test
    void processPayment(){
        CreditCardDto creditCardDto = new CreditCardDto(123L,"08142678314",0L,6L,"1234123412341234",2025L);
        PayentDto payentDto = new PayentDto(creditCardDto,"64035fc04022d11268fe63b6","64035fec4022d11268fe63b7");
        wsRaspayIntegration.processPayment(payentDto);
    }

}
