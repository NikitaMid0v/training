package com.company.training.config;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;
import com.haulmont.cuba.core.config.defaults.Default;
import com.haulmont.cuba.core.config.defaults.DefaultDouble;

@Source(type = SourceType.DATABASE)
public interface VatConfig extends Config {

    @Property("vat.value")
    @DefaultDouble(0)
    double getVat();
}