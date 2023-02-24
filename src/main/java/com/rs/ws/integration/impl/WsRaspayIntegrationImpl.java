package com.rs.ws.integration.impl;

import com.rs.ws.dto.wsraspay.CustomerDto;
import com.rs.ws.dto.wsraspay.OrderDto;
import com.rs.ws.dto.wsraspay.PayentDto;
import com.rs.ws.integration.WsRaspayIntegration;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WsRaspayIntegrationImpl implements WsRaspayIntegration {

    @Value("${webservices.raspay.host}")
    private String hostRaspay;
    @Value("${webservices.raspay.v1.costumer}")
    private String custumerUrl;
    @Value("${webservices.raspay.v1.order}")
    private String orderUrl;
    @Value("${webservices.raspay.v1.payment}")
    private String paymentUrl;

    private RestTemplate restTemplate;
    private final HttpHeaders headers;
    public WsRaspayIntegrationImpl() {
        restTemplate = new RestTemplate();
        headers =  getHttpHeaders();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto dto) {
        try {
            HttpEntity<CustomerDto> request = new HttpEntity<>(dto,this.headers);
            ResponseEntity<CustomerDto> response =
                    restTemplate.exchange(new StringBuilder(hostRaspay).append(custumerUrl).toString(), HttpMethod.POST,request,CustomerDto.class);
            return response.getBody();
        }catch (Exception e){
            throw e;
        }


    }
    public OrderDto createOrder(OrderDto dto) {
        try {
            HttpEntity<OrderDto> request = new HttpEntity<>(dto,this.headers);
            ResponseEntity<OrderDto> response =
                    restTemplate.exchange(new StringBuilder(hostRaspay).append(orderUrl).toString(), HttpMethod.POST,request,OrderDto.class);
            return response.getBody();
        }catch (Exception e){
            throw e;
        }


    }
    public Boolean processPayment(PayentDto dto) {
        try {
            HttpEntity<PayentDto> request = new HttpEntity<>(dto,this.headers);
            ResponseEntity<Boolean> response =
                    restTemplate.exchange(new StringBuilder(hostRaspay).append(paymentUrl).toString(), HttpMethod.POST,request, Boolean.class);
            System.out.println(new StringBuilder(hostRaspay).append(paymentUrl));
            return response.getBody();
        }catch (Exception e){
            throw e;
        }


    }

    private static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        String credential = "rasmooplus:r@sm00";
        String base64 = new String(Base64.encodeBase64(credential.getBytes()));
        headers.add("Authorization","Basic "+base64);
        return headers;
    }
}
