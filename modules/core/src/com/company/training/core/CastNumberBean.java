package com.company.training.core;

import com.ibm.icu.text.RuleBasedNumberFormat;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Locale;

@Component(CastNumberBean.NAME)
public class CastNumberBean {
    public static final String NAME = "training_CastNumberBean";

    public String toStringFormat(BigDecimal number){
        return new RuleBasedNumberFormat(Locale.forLanguageTag("ru"), RuleBasedNumberFormat.SPELLOUT).format(number);
    }
}