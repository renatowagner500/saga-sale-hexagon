package com.renatowagner.inventory.application.core.usecase;

import com.renatowagner.inventory.adapters.out.log.GenerateLogAdapter;
import com.renatowagner.inventory.application.core.domain.Sale;
import com.renatowagner.inventory.application.core.domain.enums.SaleEvent;
import com.renatowagner.inventory.application.ports.in.DebitInventoryInputPort;
import com.renatowagner.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.renatowagner.inventory.application.ports.out.GenerateLogOutputPort;
import com.renatowagner.inventory.application.ports.out.MessagingInventoryOutputPort;
import com.renatowagner.inventory.application.ports.out.UpdateInventoryOutputPort;

public class DebitInventoryUseCase implements DebitInventoryInputPort {


    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final UpdateInventoryOutputPort updateInventoryOutputPort;
    private final MessagingInventoryOutputPort messagingInventoryOutputPort;

    private final GenerateLogOutputPort generateLogOutputPort;

    public DebitInventoryUseCase(FindInventoryByProductIdInputPort findInventoryByProductIdInputPort, UpdateInventoryOutputPort updateInventoryOutputPort,
                                 MessagingInventoryOutputPort messagingInventoryOutputPort, GenerateLogOutputPort generateLogOutputPort) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.messagingInventoryOutputPort = messagingInventoryOutputPort;
        this.generateLogOutputPort = generateLogOutputPort;
    }

    @Override
    public void debit(Sale sale) {
        try {
            var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
            if (inventory.getQuantity() < sale.getQuantity()) {
                throw new RuntimeException("Estoque insuficiente");
            }

            inventory.debitQuantity(sale.getQuantity());
            updateInventoryOutputPort.update(inventory);
            messagingInventoryOutputPort.send(sale, SaleEvent.UPDATED_INVENTORY);
        } catch (Exception e) {
            generateLogOutputPort.error("Erro ao baixar o estoque", e);
            messagingInventoryOutputPort.send(sale, SaleEvent.ROLLBACK_INVENTORY);
        }


    }
}
