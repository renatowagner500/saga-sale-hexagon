package com.renatowagner.payment.adapters.out;

import com.renatowagner.payment.adapters.out.message.SaleMessage;
import com.renatowagner.payment.application.core.domain.Sale;
import com.renatowagner.payment.application.core.domain.enums.SaleEvent;
import com.renatowagner.payment.application.ports.out.MessagingOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessagingAdapter implements MessagingOutputPort {
    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent saleEvent) {
        var saleMessage = new SaleMessage(sale, saleEvent);
        kafkaTemplate.send("tp-saga-sale", saleMessage);
    }
}
