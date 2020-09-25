package com.company.training.web.screens.servicecompletioncertificate;

import com.haulmont.cuba.gui.screen.*;
import com.company.training.entity.ServiceCompletionCertificate;

@UiController("training_ServiceCompletionCertificate.edit")
@UiDescriptor("service-completion-certificate-edit.xml")
@EditedEntityContainer("serviceCompletionCertificateDc")
@LoadDataBeforeShow
public class ServiceCompletionCertificateEdit extends StandardEditor<ServiceCompletionCertificate> {
}