package com.bitnami.kafka.inventory_service.listener;

import com.bitnami.kafka.inventory_service.service.InventoryService;
import com.bitnami.kafka.inventory_service.model.Inventory;
import com.bitnami.kafka.inventory_service.repository.InventoryRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bitnami.kafka.inventory_service.dto.Order;

@Service
public class OrderEventListener {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "orders", groupId = "inventory-group")
    public void consume(String message) {
        try {
            Order order = objectMapper.readValue(message, Order.class);
            System.out.println("✅ Processed Order: " + order.getItem());

            // Process the order and reduce inventory
            boolean success = inventoryService.processOrder(order);

            if (success) {
                System.out.println("✅ Order fulfilled: " + order.getItem());
            } else {
                System.out.println("❌ Order failed - Out of stock: " + order.getItem());
            }

            // Check if item is in stock
            /*
             * Inventory inventory =
             * inventoryRepository.findBySkuCode(order.getItem()).orElse(null);
             * if (inventory != null && inventory.getQuantity() >= order.getQuantity()) {
             * System.out.println("✅ Item in stock: " + order.getItem());
             * } else {
             * System.out.println("❌ Out of stock: " + order.getItem());
             * }
             */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
