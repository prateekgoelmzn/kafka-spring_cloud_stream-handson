package com.pg.kafka.producer;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MsgProducer {

    @Value("${producer.topic}")
    private String topic;
    private final StreamBridge streamBridge;

    public MsgProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void produce(String message) {
        Message<String> msg = MessageBuilder.withPayload(message)
                .setHeader(KafkaHeaders.KEY, UUID.randomUUID().toString().getBytes())
                .build();
        streamBridge.send(topic, msg);
    }

}
