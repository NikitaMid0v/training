package com.company.training.core;

import com.company.training.config.VatConfig;
import com.company.training.entity.Contract;
import com.company.training.entity.Organization;
import com.haulmont.cuba.core.global.Configuration;
import com.ibm.icu.text.RuleBasedNumberFormat;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Optional;

@Component(CalculateBean.NAME)
public class CalculateBean {
    public static final String NAME = "training_CalculateBean";

    @Inject
    private Configuration configuration;

    public BigDecimal calculateVat(Contract contract){
        BigDecimal amount = Optional.ofNullable(contract)
                .map(Contract::getAmount)
                .orElse(BigDecimal.valueOf(0));
        if (organizationsHasNoVat(contract)) {
            return BigDecimal.valueOf(0);
        }
        return toPercent(BigDecimal.valueOf(
                configuration.getConfig(VatConfig.class).getVat()))
                .multiply(amount);
    }

    public BigDecimal calculateTotalAmount(Contract contract, BigDecimal vat) {
        BigDecimal amount = Optional.of(contract)
                .map(Contract::getAmount)
                .orElse(BigDecimal.valueOf(0));

        return amount.add(vat);
    }

    private BigDecimal toPercent(BigDecimal sourceValue) {
        return sourceValue.multiply(new BigDecimal("0.01"));
    }

    private boolean organizationsHasNoVat(Contract contract){

        Optional<Contract> contractOptional = Optional.ofNullable(contract);

        return contractOptional.map(Contract::getCustomer).map(Organization::getEscapeVat).orElse(true) ||
                contractOptional.map(Contract::getPerformer).map(Organization::getEscapeVat).orElse(true);
    }
}