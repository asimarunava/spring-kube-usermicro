package com.vortexmind.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService{

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${devglan.kafka.topic}")
    private String kafkaTopic;

    @Override
    public void send() {
         for(int i = 0; i < 10; i++){
            System. out.println(i);
            kafkaTemplate.send(kafkaTopic, Integer.toString(i),  "test message - " + i );
        }

    }
}