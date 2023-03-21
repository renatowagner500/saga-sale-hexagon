package com.renatowagner.orchestrator.application.core.usecase;

import com.renatowagner.orchestrator.application.core.domain.Sale;
import com.renatowagner.orchestrator.application.core.domain.enums.SaleEvent;
import com.renatowagner.orchestrator.application.ports.in.WorkflowInputPort;
import com.renatowagner.orchestrator.application.ports.out.GenerateLogOutputPort;
import com.renatowagner.orchestrator.application.ports.out.SendSaleToTopicOutputPort;

public class InventoryPreparedUseCase  implements WorkflowInputPort    {

    private SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    private GenerateLogOutputPort generateLogOutputPort;

    public InventoryPreparedUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort, GenerateLogOutputPort generateLogOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
        this.generateLogOutputPort = generateLogOutputPort;
    }

    @Override
    public void execute(Sale sale) {
        generateLogOutputPort.info("Inicio do Pagamento venda");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.EXECUTE_PAYMENT, "tp-saga-payment");
        generateLogOutputPort.info("Pagamento Enviado para fila");

    }

    @Override
    public boolean isCalledBytheEvent(SaleEvent saleEvent) {
        return SaleEvent.INVENTORY_PREPARED.equals(saleEvent);
    }
}
