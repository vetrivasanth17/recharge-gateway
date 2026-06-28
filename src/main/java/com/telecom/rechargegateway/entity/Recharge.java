package com.telecom.rechargegateway.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "recharge")
@Data
public class Recharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mobileNumber;

    private String plan;

    private Double amount;

    private String paymentMode;

    private String status;

    private LocalDateTime rechargeDate;
}