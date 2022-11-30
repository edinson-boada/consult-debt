package com.unmsm.sistemas.microservice.consultdebt.model.dto;

import com.unmsm.sistemas.microservice.consultservice.model.ServiceEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Debt {
    private String id;
    private ServiceEntity service;
    private Double monthlyPayment;
    private LocalDate expirationDate;
    private Double latePayment;
    private boolean isPayed;
}