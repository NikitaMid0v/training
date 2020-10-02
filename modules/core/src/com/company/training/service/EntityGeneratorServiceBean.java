package com.company.training.service;

import com.company.training.core.EntityGeneratorBean;
import com.company.training.entity.*;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(EntityGeneratorService.NAME)
public class EntityGeneratorServiceBean implements EntityGeneratorService {

    @Inject
    private EntityGeneratorBean entityGeneratorBean;

    public Invoice generateInvoice(Stage stage) {
        return entityGeneratorBean.generateInvoice(stage);
    }

    public ServiceCompletionCertificate generateCertificate(Stage stage) {
        return entityGeneratorBean.generateCertificate(stage);
    }

    @Override
    public Status generateStatus(String name, String code) {
        return entityGeneratorBean.generateStatus(name, code);
    }

    @Override
    public Stage generateDefaultStage(Contract contract) {
        return entityGeneratorBean.generateDefaultStage(contract);
    }
}