package com.bitnami.kafka.inventory_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @Column(name = "sku_code", nullable = false, unique = true)
    private String skuCode;

    @Column(name = "quantity")
    private int quantity;

    public Inventory() {
    }

    public Inventory(String skuCode, int quantity) {
        this.skuCode = skuCode;
        this.quantity = quantity;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
