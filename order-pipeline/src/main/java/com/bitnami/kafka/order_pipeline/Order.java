package com.bitnami.kafka.order_pipeline;

public class Order {

    private String id;
    private String item;
    private int quantity;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return "Order{id='" + id + "', item='" + item + "', quantity=" + quantity + "}";
    }
}