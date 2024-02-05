package com.uahannam.readmodel.example.dto;

public record SaveUserKafkaDto(
        UserInfo userInfo,
        UserEventDto userEvent
) {

}

