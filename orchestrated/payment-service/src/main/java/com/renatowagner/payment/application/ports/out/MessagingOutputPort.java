package com.renatowagner.payment.application.ports.out;

import com.renatowagner.payment.application.core.domain.Sale;
import com.renatowagner.payment.application.core.domain.enums.SaleEvent;

public interface MessagingOutputPort {

    void send(Sale sale, SaleEvent saleEvent);
}
