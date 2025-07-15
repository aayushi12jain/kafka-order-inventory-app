package com.bitnami.kafka.inventory_service.controller;

import com.bitnami.kafka.inventory_service.service.InventoryService;
import com.bitnami.kafka.inventory_service.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bitnami.kafka.inventory_service.model.Inventory;
import java.util.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping
    public InventoryResponse isInStock(@RequestParam("skuCode") String skuCode) {
        boolean inStock = inventoryService.isInStock(skuCode);
        return new InventoryResponse(skuCode, inStock);
    }

    @GetMapping("/all")
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    /*@PostMapping
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryService.saveInventory(inventory);
    }*/

    @PostMapping
    public ResponseEntity<String> addInventory(@RequestBody Inventory inventory) {
        inventoryRepository.save(inventory);
        return ResponseEntity.ok("Inventory item added successfully!");
    }



    // Response DTO
    static class InventoryResponse {
        private String skuCode;
        private boolean inStock;

        public InventoryResponse(String skuCode, boolean inStock) {
            this.skuCode = skuCode;
            this.inStock = inStock;
        }

        public String getSkuCode() {
            return skuCode;
        }

        public boolean isInStock() {
            return inStock;
        }
    }
}
