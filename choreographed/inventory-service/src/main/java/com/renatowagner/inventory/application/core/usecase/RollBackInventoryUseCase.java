package com.renatowagner.inventory.application.core.usecase;

import com.renatowagner.inventory.application.core.domain.Sale;
import com.renatowagner.inventory.application.core.domain.enums.SaleEvent;
import com.renatowagner.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.renatowagner.inventory.application.ports.in.RollBackInventoryInputPort;
import com.renatowagner.inventory.application.ports.out.MessagingInventoryOutputPort;
import com.renatowagner.inventory.application.ports.out.UpdateInventoryOutputPort;

public class RollBackInventoryUseCase implements RollBackInventoryInputPort {

    FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    UpdateInventoryOutputPort updateInventoryOutputPort;

    MessagingInventoryOutputPort messagingInventoryOutputPort;

    public RollBackInventoryUseCase(FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
                                    UpdateInventoryOutputPort updateInventoryOutputPort,
                                    MessagingInventoryOutputPort messagingInventoryOutputPort) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.messagingInventoryOutputPort = messagingInventoryOutputPort;
    }

    @Override
    public void rollBack(Sale sale) {
        var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
        inventory.creditQuantity(sale.getQuantity());
        updateInventoryOutputPort.update(inventory);
        messagingInventoryOutputPort.send(sale, SaleEvent.ROLLBACK_INVENTORY);
    }
}
