package com.rs.ws.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "subcription_type")
public class SubscriptionType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "sub_type_seq")
    private Long id;
    private String name;
    private Long acessMonth;
    private BigDecimal price;
    @Column(name = "prud_key",unique = true)
    private String pruductKey;


}
