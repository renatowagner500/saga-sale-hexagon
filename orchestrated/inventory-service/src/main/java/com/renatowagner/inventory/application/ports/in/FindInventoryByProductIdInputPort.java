package com.renatowagner.inventory.application.ports.in;

import com.renatowagner.inventory.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort {
    Inventory find(Integer productId);
}
