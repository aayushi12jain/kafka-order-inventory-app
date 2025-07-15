package com.bitnami.kafka.inventory_service.service;

import com.bitnami.kafka.inventory_service.model.Inventory;
import com.bitnami.kafka.inventory_service.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitnami.kafka.inventory_service.dto.Order;
import java.util.*;

import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode) {
        Optional<Inventory> inventory = inventoryRepository.findBySkuCode(skuCode);
        return inventory.map(inv -> inv.getQuantity() > 0).orElse(false);
    }

    public boolean processOrder(Order order) {
        Optional<Inventory> inventoryOpt = inventoryRepository.findBySkuCode(order.getItem());

        if (inventoryOpt.isPresent()) {
            Inventory inventory = inventoryOpt.get();
            if (inventory.getQuantity() >= order.getQuantity()) {
                inventory.setQuantity(inventory.getQuantity() - order.getQuantity());
                inventoryRepository.save(inventory);
                System.out.println("✅ Order fulfilled: " + order.getItem());
                return true;
            } else {
                System.out.println("❌ Not enough stock for: " + order.getItem());
                return false;
            }
        } else {
            System.out.println("❌ Item not found: " + order.getItem());
            return false;
        }
    }

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }


}
