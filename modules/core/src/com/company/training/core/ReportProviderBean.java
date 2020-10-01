package com.company.training.core;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.TypedQuery;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.reports.entity.Report;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Component(ReportProviderBean.NAME)
public class ReportProviderBean {
    public static final String NAME = "training_ReportProviderBean";
    @Inject
    private Persistence persistence;
    @Inject
    private TimeSource timeSource;

    @Transactional
    public Report getReport(String code){
        TypedQuery<Report> query = persistence.getEntityManager()
                .createQuery("select r from report$Report r where r.code = :code", Report.class)
                .setParameter("code", code)
                .setViewName("report-custom-view");

        return query.getSingleResult();
    }
}