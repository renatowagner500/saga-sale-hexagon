package com.renatowagner.sale.adapters.out;

import com.renatowagner.sale.adapters.message.SaleMessage;
import com.renatowagner.sale.application.core.domain.Sale;
import com.renatowagner.sale.application.core.domain.enums.SaleEvent;
import com.renatowagner.sale.application.ports.out.SendCreateSaleOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCreatedSaleAdapter implements SendCreateSaleOutputPort {

    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send("tp-saga-sale", saleMessage);
    }
}
