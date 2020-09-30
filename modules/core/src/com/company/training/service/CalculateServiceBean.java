package com.company.training.service;

import com.company.training.core.CalculateBean;
import com.company.training.entity.Contract;
import com.ibm.icu.text.RuleBasedNumberFormat;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;

@Service(CalculateService.NAME)
public class CalculateServiceBean implements CalculateService {

    @Inject
    private CalculateBean calculateBean;

    @Override
    public BigDecimal calculateTotalAmount(Contract contract, BigDecimal vat) {
        return calculateBean.calculateTotalAmount(contract, vat);
    }

    @Override
    public BigDecimal calculateVat(Contract contract){
        return calculateBean.calculateVat(contract);
    }
}