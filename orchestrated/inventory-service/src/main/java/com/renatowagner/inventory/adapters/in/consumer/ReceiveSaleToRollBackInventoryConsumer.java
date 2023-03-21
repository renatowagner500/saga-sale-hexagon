package com.renatowagner.inventory.adapters.in.consumer;

import com.renatowagner.inventory.adapters.out.message.SaleMessage;
import com.renatowagner.inventory.application.core.domain.enums.SaleEvent;
import com.renatowagner.inventory.application.ports.in.RollBackInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToRollBackInventoryConsumer {

    @Autowired
    private RollBackInventoryInputPort rollBackInventoryInputPort;

    @KafkaListener(topics = "tp-saga-inventory", groupId = "rollback-inventory")
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.EXECUTE_ROLLBACK.equals(saleMessage.getEvent())) {
            log.info("Inicio da rollback de mercadoria");
            rollBackInventoryInputPort.rollBack(saleMessage.getSale());
            log.info("Fim da rollback de mercadoria");
        }

    }

}
