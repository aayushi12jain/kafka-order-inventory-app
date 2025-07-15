package com.bitnami.kafka.inventory_service.repository;

import com.bitnami.kafka.inventory_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, String> {
    Optional<Inventory> findBySkuCode(String skuCode);
}
