package com.techmagister.springkafkatester.serviceImpl;

import com.techmagister.springkafkatester.dto.ProducerDetailsDto;
import com.techmagister.springkafkatester.dto.ResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class KafkaProducerServiceImplTest {

    @Autowired
    private KafkaProducerServiceImpl kafkaProducerService;

    @Test
    void produceSampleMessage() {

        ProducerDetailsDto producerDetailsDto = new ProducerDetailsDto();
        producerDetailsDto.setKey("123");
        producerDetailsDto.setMessage("Helo 123");
        producerDetailsDto.setTopic("kafkatester");
        producerDetailsDto.setIterations(1);

        ResponseDto responseDto = kafkaProducerService.produceSampleMessage(producerDetailsDto);
        System.out.println(responseDto.getResponseMessage());
        assertNotNull(responseDto.getResponseMessage());

    }
}