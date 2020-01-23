package com.techmagister.springkafkatester.controller;

import com.techmagister.springkafkatester.dto.ProducerDetailsDto;
import com.techmagister.springkafkatester.dto.ResponseDto;
import com.techmagister.springkafkatester.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka-tester")
public class ProducerController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/produce-message")
    public ResponseEntity<String> produceMessage (@RequestBody ProducerDetailsDto producerDetailsDto){

        ResponseDto responseDto = kafkaProducerService.produceSampleMessage(producerDetailsDto);

        return ResponseEntity.ok(responseDto.getResponseMessage());
    }
}
