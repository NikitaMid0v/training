package com.company.training.service;

import com.company.training.entity.Invoice;
import com.company.training.entity.ServiceCompletionCertificate;
import com.company.training.entity.Stage;

public interface EntityGeneratorService {
    String NAME = "training_EntityGeneratorService";

    Invoice generateInvoice(Stage stage);

    ServiceCompletionCertificate generateCertificate(Stage stage);
}