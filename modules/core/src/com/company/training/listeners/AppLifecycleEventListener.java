package com.company.training.listeners;

import com.haulmont.cuba.core.global.Resources;
import com.haulmont.cuba.core.sys.events.AppContextStartedEvent;
import com.haulmont.cuba.security.app.Authenticated;
import com.haulmont.reports.ReportImportExportAPI;
import org.apache.commons.compress.utils.IOUtils;
import org.slf4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.IOException;

@Component("training_AppLifecycleEventListener_ApplicationContextListener")
public class AppLifecycleEventListener {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(AppLifecycleEventListener.class);
    @Inject
    private ReportImportExportAPI reportImportExportAPI;
    @Inject
    private Resources resources;

    @EventListener
    @Authenticated
    public void applicationContextStarted(AppContextStartedEvent event){
        try {
            reportImportExportAPI.importReports(IOUtils.toByteArray(resources.getResourceAsStream("com/company/training/resources/certificateReport.zip")));
            reportImportExportAPI.importReports(IOUtils.toByteArray(resources.getResourceAsStream("com/company/training/resources/invoiceReport.zip")));
        } catch (IOException | NullPointerException e) {
            log.info("Error loading reports", e);
        }

    }
}