package com.vortexmind.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface ConsumerService {
    public void receive(ConsumerRecord record);
}
