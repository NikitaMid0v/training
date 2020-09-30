package com.company.training.service;

import com.haulmont.reports.entity.Report;

public interface ReportProviderService {
    String NAME = "training_ReportProviderService";
    Report getReport(String code);
}