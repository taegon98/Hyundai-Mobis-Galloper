package com.server.api.controller;

import com.server.api.ResponseDto;
import com.server.api.dto.member.MemberSignUpRequest;
import com.server.domain.Member;
import com.server.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@CrossOrigin
public class MemberApiController {

    private final MemberService memberService;

    //회원등록
    public ResponseEntity<ResponseDto> saveMember(@Validated @RequestBody MemberSignUpRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(new ResponseDto("error"));
        }

        Member member = new Member();

        member.register(request.getName(), request.getUserId(), request.getPassword(), request.getTelephone(), request.getChildName());
        memberService.join(member);

        return ResponseEntity.ok().body(new ResponseDto("회원가입이 완료되었습니다."));
    }
}
