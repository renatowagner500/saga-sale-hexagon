package com.renatowagner.orchestrator.adapters.out;

import com.renatowagner.orchestrator.adapters.out.message.SaleMessage;
import com.renatowagner.orchestrator.application.core.domain.Sale;
import com.renatowagner.orchestrator.application.core.domain.enums.SaleEvent;
import com.renatowagner.orchestrator.application.ports.out.SendSaleToTopicOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendToTopicAdapter implements SendSaleToTopicOutputPort {
    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent event, String topic) {
        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send(topic, saleMessage);
    }
}
