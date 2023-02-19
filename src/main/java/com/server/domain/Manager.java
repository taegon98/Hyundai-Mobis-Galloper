package com.server.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Manager {
    @Id
    @GeneratedValue
    @Column(name = "MANAGER_ID")
    private Long id;
    private String name;
    private String userId;
    private String password;
    private String telephone;
    private String token;   //car_serial

    @ElementCollection
    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Member> members = new ArrayList<>();

    //회원등록 생성자
    public void register(String name, String userId, String password, String telephone) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.telephone = telephone;
        this.token = UUID.randomUUID().toString();
    }
}
