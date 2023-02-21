package com.server.api.dto.manager;

import lombok.Data;

@Data
public class ManagerLoginResponse {
    private String name;
    private String token;

    public ManagerLoginResponse(String name, String token) {
        this.name = name;
        this.token = token;
    }

}
