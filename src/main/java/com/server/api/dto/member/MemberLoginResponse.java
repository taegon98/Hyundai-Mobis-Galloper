package com.server.api.dto.member;

import lombok.Data;

@Data
public class MemberLoginResponse {

    private String userId;
    private String name;
    private String childName;
    private String token;

    public MemberLoginResponse(String userId, String name, String childName, String token) {
        this.userId = userId;
        this.name = name;
        this.childName = childName;
        this.token = token;
    }

}