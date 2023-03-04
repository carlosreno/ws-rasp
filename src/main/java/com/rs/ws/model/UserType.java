package com.rs.ws.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class UserType implements GrantedAuthority {
    @Id
    @GeneratedValue(generator = "suser_type_id_seq", strategy = GenerationType.AUTO)
    @Column(name = "user_type_id")
    private Long id;
    private String name;
    private String description;


    @Override
    public String getAuthority() {
        return name;
    }
}
