package com.rs.ws.service;

import com.rs.ws.dto.SubscriptionTypeDto;
import com.rs.ws.model.SubscriptionType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubscriptionTypeService {

    List<SubscriptionType> findAll();
    SubscriptionType findById(Long id);
    SubscriptionType create(SubscriptionTypeDto subscriptionTypeDto);
    SubscriptionType update(Long id, SubscriptionTypeDto subscriptionTypeDto);

    void delete(Long id);
}
