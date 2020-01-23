package com.techmagister.springkafkatester.service;

import com.techmagister.springkafkatester.dto.ProducerDetailsDto;
import com.techmagister.springkafkatester.dto.ResponseDto;

public interface KafkaProducerService {

    ResponseDto produceSampleMessage(ProducerDetailsDto producerDetailsDto);
}
