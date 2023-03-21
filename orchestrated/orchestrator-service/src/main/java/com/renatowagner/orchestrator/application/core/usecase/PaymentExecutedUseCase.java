package com.renatowagner.orchestrator.application.core.usecase;

import com.renatowagner.orchestrator.application.core.domain.Sale;
import com.renatowagner.orchestrator.application.core.domain.enums.SaleEvent;
import com.renatowagner.orchestrator.application.ports.in.WorkflowInputPort;
import com.renatowagner.orchestrator.application.ports.out.GenerateLogOutputPort;
import com.renatowagner.orchestrator.application.ports.out.SendSaleToTopicOutputPort;

public class PaymentExecutedUseCase  implements WorkflowInputPort    {

    private SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    private GenerateLogOutputPort generateLogOutputPort;

    public PaymentExecutedUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort, GenerateLogOutputPort generateLogOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
        this.generateLogOutputPort = generateLogOutputPort;
    }

    @Override
    public void execute(Sale sale) {
        generateLogOutputPort.info("Inicio Finalizacao venda");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.FINALIZE_SALE, "tp-saga-sale");
        generateLogOutputPort.info("Pagamento Finalizacao para fila");

    }

    @Override
    public boolean isCalledBytheEvent(SaleEvent saleEvent) {
        return SaleEvent.PAYMENT_EXECUTED.equals(saleEvent);
    }
}
