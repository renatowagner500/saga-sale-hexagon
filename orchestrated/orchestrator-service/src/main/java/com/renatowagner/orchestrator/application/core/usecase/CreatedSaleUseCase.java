package com.renatowagner.orchestrator.application.core.usecase;

import com.renatowagner.orchestrator.application.core.domain.Sale;
import com.renatowagner.orchestrator.application.core.domain.enums.SaleEvent;
import com.renatowagner.orchestrator.application.ports.in.WorkflowInputPort;
import com.renatowagner.orchestrator.application.ports.out.GenerateLogOutputPort;
import com.renatowagner.orchestrator.application.ports.out.SendSaleToTopicOutputPort;

public class CreatedSaleUseCase implements WorkflowInputPort {

    private SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    private GenerateLogOutputPort generateLogOutputPort;

    public CreatedSaleUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort,
                              GenerateLogOutputPort generateLogOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
        this.generateLogOutputPort = generateLogOutputPort;
    }

    @Override
    public void execute(Sale sale) {
        generateLogOutputPort.info("Inicio Separacao Estoque");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.PREPARE_INVENTORY, "tp-saga-inventory");
        generateLogOutputPort.info("Enviado para a fila da separacao de estoque");
    }

    @Override
    public boolean isCalledBytheEvent(SaleEvent saleEvent) {
        return SaleEvent.CREATED_SALE.equals(saleEvent);
    }
}
