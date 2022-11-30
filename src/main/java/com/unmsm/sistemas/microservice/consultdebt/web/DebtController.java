package com.unmsm.sistemas.microservice.consultdebt.web;

import com.unmsm.sistemas.microservice.consultdebt.model.DebtEntity;
import com.unmsm.sistemas.microservice.consultdebt.model.dto.Debt;
import com.unmsm.sistemas.microservice.consultdebt.service.DebtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/debts")
@RequiredArgsConstructor
public class DebtController {
    private final DebtService debtService;

    @GetMapping("/customer/{id}")
    public List<Debt> getDebtByServiceCustomerId(@PathVariable("id") String id) {
        return debtService.getByServiceCustomerId(id);
    }

    @GetMapping("/{id}")
    public DebtEntity getDebtById(@PathVariable("id") String id) {
        return debtService.getDebtById(id);
    }

    @PostMapping
    public DebtEntity updateDebt(@RequestBody DebtEntity debtEntity) {
        return debtService.updateDebt(debtEntity);
    }
}