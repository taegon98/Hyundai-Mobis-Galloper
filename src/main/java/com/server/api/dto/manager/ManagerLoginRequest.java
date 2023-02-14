package com.server.api.dto.manager;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ManagerLoginRequest {

    @NotBlank(message = "아이디를 입력해주세요.")
    private String userId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;
}
