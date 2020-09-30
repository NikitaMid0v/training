package com.company.training.service;

import com.company.training.entity.Contract;

import java.math.BigDecimal;

public interface CalculateService {
    String NAME = "training_CalculateService";

    BigDecimal calculateVat(Contract contract);

    BigDecimal calculateTotalAmount(Contract contract, BigDecimal vat);
}