package com.uahannam.readmodel.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Builder
@AllArgsConstructor
@Table(name = "USERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Column(name = "USER_NICKNAME")
    private String userNickName;
}
