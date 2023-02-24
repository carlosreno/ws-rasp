package com.rs.ws.dto.wsraspay;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayentDto {

    private CreditCardDto creditCard;
    private String customerId;
    private String orderId;

}
