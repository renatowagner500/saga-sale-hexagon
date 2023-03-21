package com.renatowagner.orchestrator.application.ports.out;

import com.renatowagner.orchestrator.application.core.domain.Sale;
import com.renatowagner.orchestrator.application.core.domain.enums.SaleEvent;

public interface SendSaleToTopicOutputPort {

    void send(Sale sale, SaleEvent saleEvent, String topic);
}
