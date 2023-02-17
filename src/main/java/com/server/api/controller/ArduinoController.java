package com.server.api.controller;

import com.server.api.dto.ardu.ArduLoginResponse;
import com.server.api.dto.member.MemberLoginRequest;
import com.server.api.dto.member.MemberLoginResponse;
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
@RequestMapping("/ardu")
@RequiredArgsConstructor
@CrossOrigin
public class ArduinoController {

    private final MemberService memberService;

    @PostMapping("/member/login")
    public ResponseEntity loginMember(@RequestBody @Validated MemberLoginRequest dto,
                                      BindingResult bindingResult) {

        Member member = memberService.Login(dto.getUserId(), dto.getPassword());

        if (member.equals(null)) {
            return ResponseEntity.ok().body(new ArduLoginResponse(-1));
        } else if (member.getFid() == 0) {
            return ResponseEntity.ok().body(new ArduLoginResponse(128));
        } else {
            return ResponseEntity.ok().body(new ArduLoginResponse(1));
        }
    }
}
