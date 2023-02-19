package com.server.api.dto.member;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MemberSignUpRequest {

    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "아이디를 입력해주세요.")
    private String userId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    @NotBlank(message = "전화번호를 입력해주세요.")
    private String telephone;

    @NotBlank(message = "자녀의 이름을 입력해주세요")
    private String childName;
}
