package com.contracts.controller;

import com.contracts.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/contracts")
public class ContractsController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/create")
    public ResponseEntity<?> sendContracts() {

        for (int i = 1; i <= 10; i++) {
            this.kafkaService.sendContracts(""+Math.round(Math.random() * 999999));
        }

        return new ResponseEntity<>(Map.of("message", "accord contracts sent"), HttpStatus.OK);
    }

}
