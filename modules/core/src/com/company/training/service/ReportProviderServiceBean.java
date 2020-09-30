package com.company.training.service;

import com.company.training.core.ReportProviderBean;
import com.haulmont.reports.entity.Report;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(ReportProviderService.NAME)
public class ReportProviderServiceBean implements ReportProviderService {

    @Inject
    private ReportProviderBean reportProviderBean;

    @Override
    public Report getReport(String code) {
        return reportProviderBean.getReport(code);
    }
}