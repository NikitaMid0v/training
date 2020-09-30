package com.company.training.web.screens.contract;

import com.company.training.entity.Contract;
import com.company.training.entity.Stage;
import com.company.training.service.CalculateService;
import com.company.training.service.CastNumberService;
import com.haulmont.cuba.core.global.DatatypeFormatter;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@UiController("training_Contract.edit")
@UiDescriptor("contract-edit.xml")
@EditedEntityContainer("contractDc")
@LoadDataBeforeShow
public class ContractEdit extends StandardEditor<Contract> {

    public static final String amount = "amount";
    public static final String performer = "performer";
    public static final String customer = "customer";

    private static final Logger log = LoggerFactory.getLogger(ContractEdit.class);

    @Inject
    private CalculateService calculateService;
    @Inject
    private DataContext dataContext;
    @Inject
    private DatatypeFormatter datatypeFormatter;
    @Inject
    private CastNumberService castNumberService;

    @Subscribe(id = "contractDc", target = Target.DATA_CONTAINER)
    public void onContractDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<Contract> event) {
        if (amount.equals(event.getProperty())
                || customer.equals(event.getProperty())
                || performer.equals(event.getProperty())) {

            BigDecimal vat = calculateService.calculateVat(getEditedEntity());
            getEditedEntity().setVat(vat);
            getEditedEntity().setTotalAmount(calculateService.calculateTotalAmount(getEditedEntity(), vat));
        }
    }

    @Subscribe(target = Target.DATA_CONTEXT)
    public void onPreCommit(DataContext.PreCommitEvent event) {
        Contract contract = getEditedEntity();
        if(contract.getStage() == null){
            contract.setStage(createDefaultStage());
        }
    }

    private List<Stage> createDefaultStage(){
        Contract contract = getEditedEntity();
        Stage stage = dataContext.create(Stage.class);
        List<Stage> stages = new LinkedList<>();
        stage.setName("defaultStage");
        stage.setDateFrom(contract.getDateFrom());
        stage.setDateTo(contract.getDateTo());
        stage.setAmount(contract.getAmount());
        stage.setVat(contract.getVat());
        stage.setTotalAmount(contract.getTotalAmount());
        stage.setContract(contract);
        stages.add(stage);
        return stages;
    }
}