package com.company.training.web.screens.invoice;

import com.haulmont.cuba.gui.screen.*;
import com.company.training.entity.Invoice;

@UiController("training_Invoice.browse")
@UiDescriptor("invoice-browse.xml")
@LookupComponent("invoicesTable")
@LoadDataBeforeShow
public class InvoiceBrowse extends StandardLookup<Invoice> {
}