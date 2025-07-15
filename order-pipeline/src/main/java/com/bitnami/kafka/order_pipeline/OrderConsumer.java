package com.bitnami.kafka.order_pipeline;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @KafkaListener(topics = "orders", groupId = "order_group")
    public void consume(Order order) {
        System.out.println("📥 Received order from Kafka: " + order);
    }
}
