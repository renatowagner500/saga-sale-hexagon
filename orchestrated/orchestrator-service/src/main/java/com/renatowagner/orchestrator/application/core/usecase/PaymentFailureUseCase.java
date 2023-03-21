package com.renatowagner.orchestrator.application.core.usecase;

import com.renatowagner.orchestrator.application.core.domain.Sale;
import com.renatowagner.orchestrator.application.core.domain.enums.SaleEvent;
import com.renatowagner.orchestrator.application.ports.in.WorkflowInputPort;
import com.renatowagner.orchestrator.application.ports.out.GenerateLogOutputPort;
import com.renatowagner.orchestrator.application.ports.out.SendSaleToTopicOutputPort;

public class PaymentFailureUseCase implements WorkflowInputPort    {

    private SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    private GenerateLogOutputPort generateLogOutputPort;

    public PaymentFailureUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort, GenerateLogOutputPort generateLogOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
        this.generateLogOutputPort = generateLogOutputPort;
    }

    @Override
    public void execute(Sale sale) {
        generateLogOutputPort.info("Erro no pagamento");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.EXECUTE_ROLLBACK, "tp-saga-inventory");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.CANCEL_SALE, "tp-saga-sale");
        generateLogOutputPort.info("Rollback estoque e cancelamento da venda postados na fila.");

    }

    @Override
    public boolean isCalledBytheEvent(SaleEvent saleEvent) {
        return SaleEvent.PAYMENT_FAILED.equals(saleEvent);
    }
}
