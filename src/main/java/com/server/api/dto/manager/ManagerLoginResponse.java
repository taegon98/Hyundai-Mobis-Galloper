package com.server.api.dto.manager;

import lombok.Data;

@Data
public class ManagerLoginResponse {

    private String userId;
    private String name;
    private String token;

    public ManagerLoginResponse(String userId, String name, String token) {
        this.userId = userId;
        this.name = name;
        this.token = token;
    }

}
