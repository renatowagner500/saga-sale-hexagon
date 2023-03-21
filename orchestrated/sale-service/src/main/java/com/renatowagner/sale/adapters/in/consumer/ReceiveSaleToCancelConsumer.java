package com.renatowagner.sale.adapters.in.consumer;

import com.renatowagner.sale.adapters.out.message.SaleMessage;
import com.renatowagner.sale.application.core.domain.enums.SaleEvent;
import com.renatowagner.sale.application.ports.in.CancelSaleInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReceiveSaleToCancelConsumer {
    @Autowired
    private CancelSaleInputPort cancelSaleInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "cancel-sale")
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.CANCEL_SALE.equals(saleMessage.getEvent())) {
            log.info("Iniciando cancelamento da venda");
            cancelSaleInputPort.cancel(saleMessage.getSale());
            log.info("Finalizando cancelamento da venda");
        }
    }
}
