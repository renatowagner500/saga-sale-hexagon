package com.renatowagner.inventory.application.ports.in;

import com.renatowagner.inventory.application.core.domain.Sale;

public interface DebitInventoryInputPort {
    void debit(Sale sale);
}
