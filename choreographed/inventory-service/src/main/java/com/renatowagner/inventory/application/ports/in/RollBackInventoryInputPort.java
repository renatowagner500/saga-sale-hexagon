package com.renatowagner.inventory.application.ports.in;

import com.renatowagner.inventory.application.core.domain.Sale;

public interface RollBackInventoryInputPort {
    void rollBack(Sale sale);
}
