package com.rs.ws.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_paymente_info")
public class UserPaymenteInfor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "paymente_user_seq")
    private Long id;
    private String cardNumber;
    private Long cardExpirationMonth;
    private Long cardExpirationYear;
    private String cardSecurityCode;
    private BigDecimal price;
    private LocalDate dtPayment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

}
