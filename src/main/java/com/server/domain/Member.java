package com.server.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
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
    private String b_type;
    private String token;
    private boolean status;

    private int fid;

    private int flag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MANAGER_ID")
    private Manager manager;

    //회원등록 생성자
    public void register(String name, String userId, String password, String telephone, String childName, String b_type) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.telephone = telephone;
        this.childName = childName;
        this.b_type = b_type;
        this.fid = 0;
        this.flag = 0;
        this.token = UUID.randomUUID().toString();
    }

    public void registerManager(Manager manager) {
        this.manager = manager;
    }

    public void registerFingerprint(int fid) {
        this.fid = fid;
    }
    //승차 버튼
    public void getOn() {
        this.status = true;
    }

    //하차 버튼
    public void getOff() {
        this.status = false;
    }
}
