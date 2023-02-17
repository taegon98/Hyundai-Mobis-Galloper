package com.server.api.dto.ardu;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ArduRegisterRequest {

    @NotBlank(message = "아이디를 입력해주세요.")
    private String userId;

    @NotBlank(message = "필수 값 입니다.")
    private int fid;
}
