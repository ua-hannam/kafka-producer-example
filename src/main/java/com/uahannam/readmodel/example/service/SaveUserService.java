package com.uahannam.readmodel.example.service;

import com.uahannam.readmodel.example.common.EventProducer;
import com.uahannam.readmodel.example.dto.SaveUserKafkaDto;
import com.uahannam.readmodel.example.dto.UserEventDto;
import com.uahannam.readmodel.example.dto.UserInfo;
import com.uahannam.readmodel.example.entity.User;
import com.uahannam.readmodel.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class SaveUserService implements SaveUserUseCase {

    private final UserRepository userRepository;

    @Override
    public void saveUser() {
        User user = User.builder()
                        .userEmail("mj.seo@uahannam.io")
                        .userNickName("Dev Rex Seo")
                        .build();

        userRepository.save(user);


        for (int i=0; i<5; i++) {
            EventProducer.publishEvent(createKafkaDto(user));
        }
    }

    private SaveUserKafkaDto createKafkaDto(User user) {
        UserInfo userInfo = new UserInfo(
                user.getId(),
                user.getUserEmail(),
                user.getUserNickName(),
                user.getRegDate(),
                user.getModDate()
        );

        UserEventDto userEventDto = new UserEventDto(
                "1111",
                user.getId()
        );

        return new SaveUserKafkaDto(userInfo, userEventDto);
    }
}
