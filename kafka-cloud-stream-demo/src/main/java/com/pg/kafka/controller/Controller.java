package com.pg.kafka.controller;

import com.pg.kafka.producer.MsgProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
public class Controller {

    private final MsgProducer msgProducer;

    public Controller(MsgProducer msgProducer) {
        this.msgProducer = msgProducer;
    }

    @PostMapping("/send")
    public ResponseEntity<Void> produceMessage(@RequestBody String message) {
        try {
            msgProducer.produce(message);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
