package com.renatowagner.inventory.adapters.out.repository;

import com.renatowagner.inventory.adapters.out.repository.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Integer> {
    Optional<InventoryEntity> findByProductId(Integer productId);
}
