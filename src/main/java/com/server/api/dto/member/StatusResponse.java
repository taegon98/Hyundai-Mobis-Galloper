package com.server.api.dto.member;

import lombok.Data;

@Data
public class StatusResponse {

    private boolean status;

    public StatusResponse(boolean status) {
        this.status = status;
    }
}
