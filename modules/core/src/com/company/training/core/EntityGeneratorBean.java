package com.company.training.core;

import com.company.training.entity.*;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.TimeSource;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Optional;

@Component(EntityGeneratorBean.NAME)
public class EntityGeneratorBean {
    public static final String NAME = "training_EntityGeneratorBean";
    @Inject
    private TimeSource timeSource;
    @Inject
    private DataManager dataManager;


    public Invoice generateInvoice(Stage stage){
        Invoice invoice = dataManager.create(Invoice.class);
        Optional<Stage> stageOptional = Optional.ofNullable(stage);
        invoice.setAmount(stage.getAmount());
        invoice.setDate(timeSource.currentTimestamp());
        invoice.setVat(stage.getVat());
        invoice.setTotalAmount(stage.getTotalAmount());
        invoice.setDescription(stage.getDescription());
        invoice.setNumber(stageOptional.map(Stage::getContract).map(Contract::getNumber).orElse(null));
        invoice.setFiles(stageOptional.map(Stage::getContract).map(Contract::getFiles).orElse(null));
        return invoice;
    }


    public ServiceCompletionCertificate generateCertificate(Stage stage){
        ServiceCompletionCertificate certificate = dataManager.create(ServiceCompletionCertificate.class);
        Optional<Stage> stageOptional = Optional.ofNullable(stage);
        certificate.setAmount(stage.getAmount());
        certificate.setDate(timeSource.currentTimestamp());
        certificate.setVat(stage.getVat());
        certificate.setTotalAmount(stage.getTotalAmount());
        certificate.setDescription(stage.getDescription());
        certificate.setNumber(stageOptional.map(Stage::getContract).map(Contract::getNumber).orElse(null));
        certificate.setFiles(stageOptional.map(Stage::getContract).map(Contract::getFiles).orElse(null));
        return certificate;
    }

    public Status generateStatus(String name, String code){
        Status status = dataManager.create(Status.class);
        status.setName(name);
        status.setCode(code);
        return status;
    }

    public Stage generateDefaultStage(Contract contract){
        Stage stage = dataManager.create(Stage.class);
        stage.setName("defaultStage");
        stage.setDateFrom(contract.getDateFrom());
        stage.setDateTo(contract.getDateTo());
        stage.setAmount(contract.getAmount());
        stage.setVat(contract.getVat());
        stage.setTotalAmount(contract.getTotalAmount());
        stage.setContract(contract);
        return stage;
    }
}