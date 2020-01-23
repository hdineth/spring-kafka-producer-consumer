package com.techmagister.springkafkatester.serviceImpl;

import com.techmagister.springkafkatester.dto.ProducerDetailsDto;
import com.techmagister.springkafkatester.dto.ResponseDto;
import com.techmagister.springkafkatester.service.KafkaProducerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private static Logger logger = LogManager.getLogger(KafkaProducerServiceImpl.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public ResponseDto produceSampleMessage(ProducerDetailsDto producerDetailsDto) {

        ResponseDto responseDto = new ResponseDto();

        if (producerDetailsDto.getIterations() != null && producerDetailsDto.getIterations() != 0) {

            for (Integer messageNumber = 1; messageNumber <= producerDetailsDto.getIterations(); messageNumber++) {

                logger.info("Producing message: {} {} of {} to the topic {}", producerDetailsDto.getMessage(), messageNumber, producerDetailsDto.getIterations(), producerDetailsDto.getTopic());

                produceWithoutKey(producerDetailsDto);

            }

            responseDto.setResponseMessage("Request Accepted");

        } else {

            responseDto.setResponseMessage("Iteration value should not be empty or 0");
        }

        return responseDto;


    }

    private void produceWithoutKey(ProducerDetailsDto producerDetailsDto) {

        ListenableFuture<SendResult<String, String>> producerResponse = kafkaTemplate.send(producerDetailsDto.getTopic(), producerDetailsDto.getMessage());

        producerResponse.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {

                logger.error("Error occurred when publishing message: {}", ex.getMessage());

            }

            @Override
            public void onSuccess(SendResult<String, String> result) {

                logger.info("Success when publishing message: {}", producerDetailsDto.getMessage());

            }
        });
    }

}
