package com.renatowagner.sale.adapters.in.consumer;

import com.renatowagner.sale.adapters.out.message.SaleMessage;
import com.renatowagner.sale.application.core.domain.enums.SaleEvent;
import com.renatowagner.sale.application.ports.in.FinalizeSaleInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToFinalizeConsumer {

    @Autowired
    private FinalizeSaleInputPort finalizeSaleInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "sale-finalize")
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.FINALIZE_SALE.equals(saleMessage.getEvent())) {
            log.info("Inicio finalizacao venda");
            finalizeSaleInputPort.finalize(saleMessage.getSale());
            log.info("Fim finalizacao venda");
        }
    }

}
