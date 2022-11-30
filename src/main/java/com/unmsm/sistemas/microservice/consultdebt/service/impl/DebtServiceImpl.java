package com.unmsm.sistemas.microservice.consultdebt.service.impl;

import com.unmsm.sistemas.microservice.consultdebt.client.ServiceClient;
import com.unmsm.sistemas.microservice.consultdebt.model.DebtEntity;
import com.unmsm.sistemas.microservice.consultdebt.model.dto.Debt;
import com.unmsm.sistemas.microservice.consultdebt.repository.DebtRepository;
import com.unmsm.sistemas.microservice.consultdebt.service.DebtService;
import com.unmsm.sistemas.microservice.consultservice.model.ServiceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DebtServiceImpl implements DebtService {
    private final DebtRepository debtRepository;
    private final ServiceClient serviceClient;

    @Override
    public List<Debt> getByServiceCustomerId(String customerId) {
        List<ServiceEntity> services = serviceClient.getByCustomerId(Integer.parseInt(customerId));
        List<DebtEntity> debts = debtRepository.findAll();
        return getDebts(services, debts);
    }

    @Override
    public DebtEntity getDebtById(String id) {
        return debtRepository.findById(id).get();
    }

    @Override
    public DebtEntity updateDebt(DebtEntity debtEntity) {
        return debtRepository.save(debtEntity);
    }

    public List<Debt> getDebts(List<ServiceEntity> services, List<DebtEntity> debts) {
        List<Debt> debtsDto = new ArrayList<>();

        for (ServiceEntity service : services) {
            for (Debt debt : mapperToDto(debts)) {
                if (service.getId() == debt.getService().getId())
                    debtsDto.add(debt);
            }
        }
        return debtsDto;
    }

    public List<Debt> mapperToDto(List<DebtEntity> debtsEntities) {
        List<Debt> debtsDto = new ArrayList<>();
        for (DebtEntity debtEntity : debtsEntities) {
            Debt debt = new Debt();
            debt.setId(debtEntity.getId());
            debt.setService(serviceClient.getByServiceId(Integer.parseInt(debtEntity.getServiceId())));
            debt.setExpirationDate(debtEntity.getExpirationDate());
            debt.setLatePayment(debtEntity.getLatePayment());
            debt.setPayed(debtEntity.isPayed());
            debt.setMonthlyPayment(debtEntity.getMonthlyPayment());
            debtsDto.add(debt);
        }
        return debtsDto;
    }
}