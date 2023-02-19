package com.server.api.dto.manager;

import lombok.Data;

@Data
public class ManagerLoginResponse {
    private String name;

    public ManagerLoginResponse(String name) {
        this.name = name;
    }

}
