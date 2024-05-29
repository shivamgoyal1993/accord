package com.contracts.service;

import com.contracts.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendContracts(String documentMetadata) {
        this.kafkaTemplate.send(AppConstants.ACCORD_TOPIC_NAME, documentMetadata);
    }

}
