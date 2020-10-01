package com.company.training.service;

import com.company.training.core.EntityGeneratorBean;
import com.company.training.entity.Invoice;
import com.company.training.entity.ServiceCompletionCertificate;
import com.company.training.entity.Stage;
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
}