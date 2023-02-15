package com.server.api.dto.member;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterManagerRequest {

    @NotBlank(message = "아이디를 입력해주세요.")
    private String userId;
}
