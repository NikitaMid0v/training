package com.company.training.web.screens.servicecompletioncertificate;

import com.haulmont.cuba.gui.screen.*;
import com.company.training.entity.ServiceCompletionCertificate;

@UiController("training_ServiceCompletionCertificate.browse")
@UiDescriptor("service-completion-certificate-browse.xml")
@LookupComponent("serviceCompletionCertificatesTable")
@LoadDataBeforeShow
public class ServiceCompletionCertificateBrowse extends StandardLookup<ServiceCompletionCertificate> {
}