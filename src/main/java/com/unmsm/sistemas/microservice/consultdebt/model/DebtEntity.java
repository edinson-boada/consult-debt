package com.unmsm.sistemas.microservice.consultdebt.model;

import com.unmsm.sistemas.microservice.consultservice.model.ServiceEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Document(collection = "debts")
public class DebtEntity {

    @Id
    private String id;

    @Field(name = "service_id")
    private String serviceId;

    @Field(name = "monthly_payment")
    private Double monthlyPayment;

    @Field(name = "expiration_date")
    private LocalDate expirationDate;

    @Field(name = "late_payment")
    private Double latePayment;

    @Field(name = "is_payed")
    private boolean isPayed;
}