package com.company.training.web.screens.contract;

import com.company.training.entity.Invoice;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.company.training.entity.Contract;

import javax.inject.Inject;

@UiController("training_Contract.browse")
@UiDescriptor("contract-browse.xml")
@LookupComponent("contractsTable")
@LoadDataBeforeShow
public class ContractBrowse extends StandardLookup<Contract> {
    @Inject
    private GroupTable<Contract> contractsTable;
    @Inject
    private DataContext dataContext;

    public void onGenerateCertificateAndInvoiceBtnClick() {
        contractsTable.getSingleSelected();
    }
}