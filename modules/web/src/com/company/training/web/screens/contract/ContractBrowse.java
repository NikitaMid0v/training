package com.company.training.web.screens.contract;

import com.company.training.entity.Contract;
import com.haulmont.charts.gui.components.charts.PieChart;
import com.haulmont.charts.gui.data.MapDataItem;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@UiController("training_Contract.browse")
@UiDescriptor("contract-browse.xml")
@LookupComponent("contractsTable")
@LoadDataBeforeShow
public class ContractBrowse extends StandardLookup<Contract> {
    private static final Logger log = LoggerFactory.getLogger(ContractBrowse.class);
    @Inject
    private PieChart pieChart;
    @Inject
    private CollectionContainer<Contract> contractsDc;


    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        contractsDc.getItems().forEach(contract ->
                pieChart.addData(MapDataItem.of("number", contract.getNumber(),
                        "totalAmount", contract.getTotalAmount())));
    }
}