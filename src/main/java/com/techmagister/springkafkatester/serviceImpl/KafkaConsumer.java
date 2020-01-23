package com.techmagister.springkafkatester.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static Logger logger = LogManager.getLogger(KafkaProducerServiceImpl.class);

    @KafkaListener(topics = "${application.integrations.kafka.listeners.topic}")
    public void consumeMessage(String message) {
        logger.info("Got message: " + message);

    }
}
