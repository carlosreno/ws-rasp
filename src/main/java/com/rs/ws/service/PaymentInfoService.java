package com.rs.ws.service;

import com.rs.ws.dto.PaymentProcessDto;

public interface PaymentInfoService {
    Boolean process(PaymentProcessDto dto);
}
