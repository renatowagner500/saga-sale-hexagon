package com.renatowagner.inventory.adapters.out.repository.mapper;

import com.renatowagner.inventory.adapters.out.repository.entity.InventoryEntity;
import com.renatowagner.inventory.application.core.domain.Inventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryEntityMapper {
    Inventory toInventory(InventoryEntity inventoryEntity);
    InventoryEntity toInventoryEntity(Inventory inventory);
}
