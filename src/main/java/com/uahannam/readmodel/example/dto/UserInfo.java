package com.uahannam.readmodel.example.dto;

import java.time.LocalDateTime;


public record UserInfo(
        Long userId,
        String userEmail,
        String userNickName,
        LocalDateTime regDate,
        LocalDateTime modDate
) {
}
