package com.renatowagner.inventory.application.core.usecase;

import com.renatowagner.inventory.application.core.domain.Inventory;
import com.renatowagner.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.renatowagner.inventory.application.ports.out.FindInventoryByProductIdOutputPort;

public class FindInventoryByProductIdUseCase implements FindInventoryByProductIdInputPort {

    private final FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort;

    public FindInventoryByProductIdUseCase(FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort) {
        this.findInventoryByProductIdOutputPort = findInventoryByProductIdOutputPort;
    }

    @Override
    public Inventory find(Integer productId) {
        return findInventoryByProductIdOutputPort.find(productId).
                orElseThrow(() -> new RuntimeException("Estoque nao encontrado para este produto"));

    }
}
