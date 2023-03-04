package com.rs.ws.repository;

import com.rs.ws.model.UserPaymenteInfor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserPaymenteInfoRepository extends JpaRepository<UserPaymenteInfor, Long> {

}
