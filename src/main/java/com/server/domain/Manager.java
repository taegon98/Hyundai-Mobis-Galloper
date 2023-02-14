package com.server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Manager {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;
    private String userId;
    private String password;
    private String telephone;
    private String token;   //car_serial

    //회원등록 생성자
    public void register(String name, String userId, String password, String telephone) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.telephone = telephone;
        this.token = UUID.randomUUID().toString();
    }
}