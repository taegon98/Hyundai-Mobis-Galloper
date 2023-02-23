package com.server.api.dto.member;

import lombok.Data;

@Data
public class MemberLoginResponse {
    private String name;
    private String childName;
    private String token;
    private String userId;
    private int flag;
    public MemberLoginResponse(String name, String childName, String token, int flag, String userId) {
        this.name = name;
        this.childName = childName;
        this.token = token;
        this.flag = flag;
        this.userId = userId;
    }

}
