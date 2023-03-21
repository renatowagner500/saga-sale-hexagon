package com.renatowagner.inventory.adapters.in.consumer;

import com.renatowagner.inventory.adapters.out.message.SaleMessage;
import com.renatowagner.inventory.application.core.domain.enums.SaleEvent;
import com.renatowagner.inventory.application.ports.in.DebitInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReceiveSaleToDebitInventoryConsumer {

    @Autowired
    private DebitInventoryInputPort debitInventoryInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "inventory-debit")
    public void receive(SaleMessage saleMessage) {
        if(SaleEvent.CREATED_SALE.equals(saleMessage.getEvent())){
            log.info("Inicio da Separacao de mercadoria");
            debitInventoryInputPort.debit(saleMessage.getSale());
            log.info("Fim da Separacao de mercadoria");
        }
    }
}
