package com.renatowagner.sale.application.ports.out;

import com.renatowagner.sale.application.core.domain.Sale;
import com.renatowagner.sale.application.core.domain.enums.SaleEvent;

public interface SendCreateSaleOutputPort {
    void send(Sale sale, SaleEvent event);
}
