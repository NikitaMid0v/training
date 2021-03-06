package com.company.training.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Table(name = "TRAINING_INVOICE")
@Entity(name = "training_Invoice")
@NamePattern("%s|number")
public class Invoice extends StandardEntity {
    private static final long serialVersionUID = 8614832486459432822L;

    @NotNull
    @Column(name = "NUMBER_", nullable = false)
    private String number;

    @JoinTable(name = "TRAINING_INVOICE_FILE_DESCRIPTOR_LINK",
            joinColumns = @JoinColumn(name = "INVOICE_ID"),
            inverseJoinColumns = @JoinColumn(name = "FILE_DESCRIPTOR_ID"))
    @ManyToMany
    private List<FileDescriptor> files;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Column(name = "DATE_", nullable = false)
    private Date date;

    @Column(name = "AMOUNT")
    @PositiveOrZero(message = "{msg://training_Contract.amount.validation.DecimalMin}")
    private BigDecimal amount;

    @Column(name = "VAT")
    @PositiveOrZero(message = "{msg://training_Contract.amount.validation.DecimalMin}")
    private BigDecimal vat;

    @Column(name = "TOTAL_AMOUNT")
    @PositiveOrZero(message = "{msg://training_Contract.amount.validation.DecimalMin}")
    private BigDecimal totalAmount;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;

    public List<FileDescriptor> getFiles() {
        return files;
    }

    public void setFiles(List<FileDescriptor> files) {
        this.files = files;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public BigDecimal getVat() {
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