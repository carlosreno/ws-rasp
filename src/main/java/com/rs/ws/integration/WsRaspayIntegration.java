package com.rs.ws.integration;

import com.rs.ws.dto.wsraspay.CustomerDto;
import com.rs.ws.dto.wsraspay.OrderDto;
import com.rs.ws.dto.wsraspay.PayentDto;

public interface WsRaspayIntegration {
    CustomerDto createCustomer(CustomerDto dto);
    OrderDto createOrder(OrderDto orderDto);
    Boolean processPayment(PayentDto payentDto);

}
