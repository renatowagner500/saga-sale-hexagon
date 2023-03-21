package com.renatowagner.inventory.application.ports.out;

import com.renatowagner.inventory.application.core.domain.Inventory;

public interface UpdateInventoryOutputPort {
    void update(Inventory inventory);
}
