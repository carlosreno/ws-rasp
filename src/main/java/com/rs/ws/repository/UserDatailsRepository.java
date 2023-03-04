package com.rs.ws.repository;

import com.rs.ws.model.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserDatailsRepository extends JpaRepository<UserCredential,Long> {
    Optional<UserCredential> findByUserName(String userName);
}
