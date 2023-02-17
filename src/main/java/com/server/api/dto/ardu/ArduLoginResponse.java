package com.server.api.dto.ardu;

import lombok.Data;

@Data
public class ArduLoginResponse {
    private int fid;

    public ArduLoginResponse(int fid) {
        this.fid = fid;
    }
}
