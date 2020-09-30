package com.company.training.service;

import java.math.BigDecimal;

public interface CastNumberService {
    String NAME = "training_CastNumberService";

    String toStringFormat(BigDecimal number);
}