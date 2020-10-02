package com.company.training.web.screens.contract;

import com.company.training.entity.Contract;
import com.company.training.entity.Stage;
import com.company.training.service.CalculateService;
import com.company.training.service.EntityGeneratorService;
import com.haulmont.addon.bproc.service.BprocRuntimeService;
import com.haulmont.cuba.core.app.UniqueNumbersService;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.global.UserSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@UiController("training_Contract.edit")
@UiDescriptor("contract-edit.xml")
@EditedEntityContainer("contractDc")
@LoadDataBeforeShow
public class ContractEdit extends StandardEditor<Contract> {

    public static final String amount = "amount";
    public static final String performer = "performer";
    public static final String customer = "customer";

    private boolean isNewContract;

    private static final Logger log = LoggerFactory.getLogger(ContractEdit.class);

    @Inject
    private CalculateService calculateService;
    @Inject
    private DataContext dataContext;
    @Inject
    private BprocRuntimeService bprocRuntimeService;
    @Inject
    private UserSession userSession;
    @Inject
    private EntityGeneratorService entityGeneratorService;
    @Inject
    private UniqueNumbersService uniqueNumbersService;

    @Subscribe(id = "contractDc", target = Target.DATA_CONTAINER)
    public void onContractDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<Contract> event) {
        if (amount.equals(event.getProperty())
                || customer.equals(event.getProperty())
                || performer.equals(event.getProperty())) {

            BigDecimal vat = calculateService.calculateVat(getEditedEntity());
            getEditedEntity().setVat(vat);
            getEditedEntity().setTotalAmount(calculateService.calculateTotalAmount(getEditedEntity(), vat));
        }

        if("status".equals(event.getProperty())){
            log.info("Status was edited");
        }
    }

    @Subscribe
    public void onInitEntity(InitEntityEvent<Contract> event) {
        isNewContract = true;
    }

    @Subscribe(target = Target.DATA_CONTEXT)
    public void onPreCommit(DataContext.PreCommitEvent event) {
        Contract contract = getEditedEntity();
        if(contract.getStage() == null || contract.getStage().isEmpty()){
            List<Stage> stages = new LinkedList<>();
            Stage stage = dataContext.merge(entityGeneratorService.generateDefaultStage(contract));
            stages.add(stage);
            contract.setStage(stages);
        }
        if(isNewContract){
            contract.setNumber(String.valueOf(uniqueNumbersService.getNextNumber("contract")));
            contract.setStatus(dataContext.merge(entityGeneratorService.generateStatus("New", "1")));
        }
    }

    @Subscribe
    public void onAfterCommitChanges(AfterCommitChangesEvent event) throws InterruptedException {
        if(isNewContract) {
            Map<String, Object> processVariables = new HashMap<>();
            processVariables.put("Contract", getEditedEntity());
            processVariables.put("administrator", userSession.getCurrentOrSubstitutedUser());
            bprocRuntimeService.startProcessInstanceByKey("new-contract", processVariables);
        }
    }
}