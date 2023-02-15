package com.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JoinColumnOrFormula;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;
    private String userId;
    private String password;
    private String telephone;
    private String childName;
    private String token;

    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MANAGER_ID")
    private Manager manager;

    //회원등록 생성자
    public void register(String name, String userId, String password, String telephone, String childName) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.telephone = telephone;
        this.childName = childName;
        this.token = UUID.randomUUID().toString();
    }

    public void registerManager(Manager manager) {
        this.manager = manager;
    }
}
