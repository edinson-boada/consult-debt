package com.unmsm.sistemas.microservice.consultdebt.service;

import com.unmsm.sistemas.microservice.consultdebt.model.DebtEntity;
import com.unmsm.sistemas.microservice.consultdebt.model.dto.Debt;

import java.util.List;

public interface DebtService {
    List<Debt> getByServiceCustomerId(String id);
    DebtEntity getDebtById(String id);
    DebtEntity updateDebt(DebtEntity debtEntity);
}