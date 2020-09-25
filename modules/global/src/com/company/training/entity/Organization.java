package com.company.training.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Table(name = "TRAINING_ORGANIZATION")
@Entity(name = "training_Organization")
@NamePattern("%s|name")
public class Organization extends StandardEntity {
    private static final long serialVersionUID = 894604928919395608L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "TAX_NUMBER", nullable = false)
    private String taxNumber;

    @NotNull
    @Column(name = "REGISTRATION_NUMBER", nullable = false)
    private String registrationNumber;

    @Column(name = "ESCAPE_VAT")
    private BigDecimal escapeVat;

    public BigDecimal getEscapeVat() {
        return escapeVat;
    }

    public void setEscapeVat(BigDecimal escapeVat) {
        this.escapeVat = escapeVat;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}