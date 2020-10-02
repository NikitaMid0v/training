package com.company.training.service;

import com.company.training.entity.*;

import java.util.List;

public interface EntityGeneratorService {
    String NAME = "training_EntityGeneratorService";

    Invoice generateInvoice(Stage stage);

    ServiceCompletionCertificate generateCertificate(Stage stage);

    Status generateStatus(String name, String code);

    Stage generateDefaultStage(Contract contract);
}