package com.renatowagner.inventory.application.ports.out;

import com.renatowagner.inventory.application.core.domain.Inventory;

import java.util.Optional;

public interface FindInventoryByProductIdOutputPort {
    Optional<Inventory> find(final Integer productId);

}
