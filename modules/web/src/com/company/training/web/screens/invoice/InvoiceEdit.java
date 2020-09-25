package com.company.training.web.screens.invoice;

import com.haulmont.cuba.gui.screen.*;
import com.company.training.entity.Invoice;

@UiController("training_Invoice.edit")
@UiDescriptor("invoice-edit.xml")
@EditedEntityContainer("invoiceDc")
@LoadDataBeforeShow
public class InvoiceEdit extends StandardEditor<Invoice> {
}