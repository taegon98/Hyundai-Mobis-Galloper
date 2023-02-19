package com.server.api.dto.ardu;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ArduRegisterRequest {

    @NotBlank(message = "아이디를 입력해주세요.")
    private String userId;

    @NotNull
    private int fid;
}
