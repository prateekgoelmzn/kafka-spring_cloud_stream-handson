package com.pg.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Configuration
public class MsgConsumer {

    public static final String OUTLINE = "########################";
    public static final String PAYLOAD_FORMAT = "Message Received : {}";
    Logger log = LoggerFactory.getLogger(this.getClass());


    @Bean
    Consumer<Message<String>> consumeMessage() {
        return msg -> {
            log.info(OUTLINE);
            log.info(PAYLOAD_FORMAT, msg.getPayload());
            log.info(OUTLINE);
        };
    }
}
