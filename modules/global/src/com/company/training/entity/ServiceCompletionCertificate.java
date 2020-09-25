package com.company.training.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "TRAINING_SERVICE_COMPLETION_CERTIFICATE")
@Entity(name = "training_ServiceCompletionCertificate")
@NamePattern("%s|number")
public class ServiceCompletionCertificate extends StandardEntity {
    private static final long serialVersionUID = 5205435472966859842L;

    @NotNull
    @Column(name = "NUMBER_", nullable = false)
    private String number;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Column(name = "DATE_", nullable = false)
    private Date date;

    @Column(name = "VAT", nullable = false)
    @NotNull
    @PositiveOrZero(message = "{msg://training_Contract.amount.validation.DecimalMin}")
    private Double vat;

    @Column(name = "AMOUNT", nullable = false)
    @PositiveOrZero(message = "{msg://training_Contract.amount.validation.DecimalMin}")
    @NotNull
    private BigDecimal amount;

    @NotNull
    @Column(name = "TOTAL_AMOUNT", nullable = false)
    @PositiveOrZero(message = "{msg://training_Contract.amount.validation.DecimalMin}")
    private BigDecimal totalAmount;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public Double getVat() {
        return vat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}