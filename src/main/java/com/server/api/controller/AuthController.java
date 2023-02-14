package com.server.api.controller;

import com.server.api.ResponseDto;
import com.server.api.dto.member.MemberLoginRequest;
import com.server.api.dto.member.MemberLoginResponse;
import com.server.domain.Member;
import com.server.domain.SessionConst;
import com.server.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated MemberLoginRequest dto,
                                Errors errors, HttpServletRequest request) {
        String findPassword = dto.getPassword();

        Member member = memberService.Login(dto.getUserId(), dto.getPassword());

        if (member.equals(null) || errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, member);

        return ResponseEntity.ok().body(new MemberLoginResponse(member.getUserId(), member.getName(), member.getChildName(), member.getToken()));
    }

    @PostMapping("/logout")
    public ResponseEntity logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return ResponseEntity.ok().body(new ResponseDto("로그아웃 되었습니다."));
    }
}
