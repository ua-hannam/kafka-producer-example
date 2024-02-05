package com.uahannam.readmodel.example.listener;

import com.uahannam.readmodel.example.dto.SaveUserKafkaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveUserDataEventListener {


    private final KafkaTemplate<String, SaveUserKafkaDto> saveUserKafkaTemplate;

    @Async
    @EventListener(SaveUserKafkaDto.class)
    public void handleSaveEvent(SaveUserKafkaDto saveUserKafkaDto) {

        System.out.println("이벤트 발행 -> SaveUserKafkaDto 전송 중");
        System.out.println("saveUserKafkaDto = " + saveUserKafkaDto);

        saveUserKafkaTemplate.send("save-user-data", saveUserKafkaDto);
    }
}
