package com.rs.ws.repository;

import com.rs.ws.model.SubscriptionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SubscriptionTypeRepository extends JpaRepository<SubscriptionType, Long> {

}
