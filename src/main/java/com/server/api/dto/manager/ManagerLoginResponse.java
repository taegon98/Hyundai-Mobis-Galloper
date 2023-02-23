package com.server.api.dto.manager;

import lombok.Data;

@Data
public class ManagerLoginResponse {
    private String name;
    private String token;
    private String userId;
    private int flag;

    public ManagerLoginResponse(String name, String token, int flag, String userId) {
        this.name = name;
        this.token = token;
        this.flag = flag;
        this.userId = userId;
    }

}
