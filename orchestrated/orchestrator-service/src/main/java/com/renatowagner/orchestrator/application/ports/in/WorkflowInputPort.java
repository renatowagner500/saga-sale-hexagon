package com.renatowagner.orchestrator.application.ports.in;

import com.renatowagner.orchestrator.application.core.domain.Sale;
import com.renatowagner.orchestrator.application.core.domain.enums.SaleEvent;

public interface WorkflowInputPort {

    void execute(Sale sale);

    boolean isCalledBytheEvent(SaleEvent saleEvent);
}
