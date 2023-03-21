package com.renatowagner.inventory.adapters.out;

import com.renatowagner.inventory.adapters.out.message.SaleMessage;
import com.renatowagner.inventory.application.core.domain.Sale;
import com.renatowagner.inventory.application.core.domain.enums.SaleEvent;
import com.renatowagner.inventory.application.ports.out.MessagingInventoryOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessagingInventoryAdapter implements MessagingInventoryOutputPort {
    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;
    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send("tp-saga-orchestrator", saleMessage);
    }
}
