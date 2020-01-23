package com.techmagister.springkafkatester.dto;

import lombok.Data;

@Data
public class ProducerDetailsDto {

    private String message;
    private String key;
    private String topic;
    private Integer iterations;


}
