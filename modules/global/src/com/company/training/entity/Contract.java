package com.company.training.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Table(name = "TRAINING_CONTRACT")
@Entity(name = "training_Contract")
@NamePattern("%s|number")
public class Contract extends StandardEntity {
    private static final long serialVersionUID = 6054157076049799082L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CUSTOMER_ID")
    private Organization customer;

    @JoinTable(name = "TRAINING_CONTRACT_FILE_DESCRIPTOR_LINK",
            joinColumns = @JoinColumn(name = "CONTRACT_ID"),
            inverseJoinColumns = @JoinColumn(name = "FILE_DESCRIPTOR_ID"))
    @ManyToMany
    private List<FileDescriptor> files;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PERFORMER_ID")
    private Organization performer;

    @Column(name = "NUMBER_")
    private String number;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "SIGNED_DATE", nullable = false)
    private Date signedDate;

    @NotNull
    @Column(name = "TYPE_", nullable = false)
    private String type;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_TO")
    private Date dateTo;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_FROM")
    private Date dateFrom;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "contract")
    private List<Stage> stage;

    @NotNull
    @Column(name = "AMOUNT", nullable = false)
    @PositiveOrZero(message = "{msg://training_Contract.amount.validation.DecimalMin}")
    private BigDecimal amount;

    @JoinColumn(name = "CUSTOMER_SIGNER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User customerSigner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_ID")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERFORMER_SIGNER_ID")
    private User performerSigner;

    @Column(name = "VAT", nullable = false)
    @NotNull
    @PositiveOrZero(message = "{msg://training_Contract.amount.validation.DecimalMin}")
    private BigDecimal vat;

    @Column(name = "TOTAL_AMOUNT")
    @PositiveOrZero(message = "{msg://training_Contract.amount.validation.DecimalMin}")
    private BigDecimal totalAmount;

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public List<Stage> getStage() {
        return stage;
    }

    public void setStage(List<Stage> stage) {
        this.stage = stage;
    }

    public List<FileDescriptor> getFiles() {
        return files;
    }

    public void setFiles(List<FileDescriptor> files) {
        this.files = files;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCustomerSigner(User customerSigner) {
        this.customerSigner = customerSigner;
    }

    public User getCustomerSigner() {
        return customerSigner;
    }

    public User getPerformerSigner() {
        return performerSigner;
    }

    public void setPerformerSigner(User performerSigner) {
        this.performerSigner = performerSigner;
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

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Type getType() {
        return type == null ? null : Type.fromId(type);
    }

    public void setType(Type type) {
        this.type = type == null ? null : type.getId();
    }

    public Date getSignedDate() {
        return signedDate;
    }

    public void setSignedDate(Date signedDate) {
        this.signedDate = signedDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Organization getPerformer() {
        return performer;
    }

    public void setPerformer(Organization performer) {
        this.performer = performer;
    }

    public Organization getCustomer() {
        return customer;
    }

    public void setCustomer(Organization customer) {
        this.customer = customer;
    }
}