package com.renatowagner.inventory.application.core.usecase;

import com.renatowagner.inventory.application.core.domain.Sale;
import com.renatowagner.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.renatowagner.inventory.application.ports.in.RollBackInventoryInputPort;
import com.renatowagner.inventory.application.ports.out.MessagingInventoryOutputPort;
import com.renatowagner.inventory.application.ports.out.UpdateInventoryOutputPort;

public class RollBackInventoryUseCase implements RollBackInventoryInputPort {

    FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    UpdateInventoryOutputPort updateInventoryOutputPort;


    public RollBackInventoryUseCase(FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
                                    UpdateInventoryOutputPort updateInventoryOutputPort) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
    }

    @Override
    public void rollBack(Sale sale) {
        var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
        inventory.creditQuantity(sale.getQuantity());
        updateInventoryOutputPort.update(inventory);
    }
}
