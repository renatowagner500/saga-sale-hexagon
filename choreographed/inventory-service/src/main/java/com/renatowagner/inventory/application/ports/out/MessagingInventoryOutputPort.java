package com.renatowagner.inventory.application.ports.out;

import com.renatowagner.inventory.application.core.domain.Sale;
import com.renatowagner.inventory.application.core.domain.enums.SaleEvent;

public interface MessagingInventoryOutputPort {
    void send(Sale sale, SaleEvent event);
}
