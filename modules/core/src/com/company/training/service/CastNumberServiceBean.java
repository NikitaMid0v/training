package com.company.training.service;

import com.company.training.core.CastNumberBean;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;

@Service(CastNumberService.NAME)
public class CastNumberServiceBean implements CastNumberService {
    @Inject
    private CastNumberBean castNumberBean;

    @Override
    public String toStringFormat(BigDecimal number) {
        return castNumberBean.toStringFormat(number);
    }
}