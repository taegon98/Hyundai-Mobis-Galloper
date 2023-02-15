package com.server.api.controller;

import com.server.api.ResponseDto;
import com.server.api.dto.manager.ManagerLoginRequest;
import com.server.api.dto.manager.ManagerLoginResponse;
import com.server.api.dto.member.MemberLoginRequest;
import com.server.api.dto.member.MemberLoginResponse;
import com.server.domain.Manager;
import com.server.domain.Member;
import com.server.domain.SessionConst;
import com.server.service.ManagerService;
import com.server.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final MemberService memberService;
    private final ManagerService managerService;

    @PostMapping("/member/login")
    public ResponseEntity loginMember(@RequestBody @Validated MemberLoginRequest dto,
                                BindingResult bindingResult, HttpServletRequest request) {
        String findPassword = dto.getPassword();

        Member member = memberService.Login(dto.getUserId(), dto.getPassword());

        if (member.equals(null) || bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult);
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, member);

        return ResponseEntity.ok().body(new MemberLoginResponse(member.getUserId(), member.getName(), member.getChildName(), member.getToken()));
    }

    @PostMapping("/member/logout")
    public ResponseEntity logoutMember(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return ResponseEntity.ok().body(new ResponseDto("로그아웃 되었습니다."));
    }

    @PostMapping("/manager/login")
    public ResponseEntity loginManager(@RequestBody @Validated ManagerLoginRequest dto,
                                BindingResult bindingResult, HttpServletRequest request) {
        String findPassword = dto.getPassword();

        Manager manager = managerService.Login(dto.getUserId(), dto.getPassword());

        if (manager.equals(null) || bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult);
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MANAGER, manager);

        return ResponseEntity.ok().body(new ManagerLoginResponse(manager.getUserId(), manager.getName(), manager.getToken()));
    }

    @PostMapping("/manager/logout")
    public ResponseEntity logoutManager(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return ResponseEntity.ok().body(new ResponseDto("로그아웃 되었습니다."));
    }
}
