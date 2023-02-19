package com.server.api.controller;

import com.server.api.ResponseDto;
import com.server.api.dto.ardu.ArduLoginResponse;
import com.server.api.dto.ardu.ArduRegisterRequest;
import com.server.api.dto.member.MemberLoginRequest;
import com.server.domain.Member;
import com.server.exception.MethodArgumentNotValidException;
import com.server.service.MemberService;

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

        if (member == null) {
            return ResponseEntity.ok().body(new ArduLoginResponse(-1));
        } else if (member.getFid() == 0) {
            return ResponseEntity.ok().body(new ArduLoginResponse(128));
        } else {
            return ResponseEntity.ok().body(new ArduLoginResponse(1));
        }
    }

    @PostMapping("/member/regFinger")
    public ResponseEntity regFingerprint(@RequestBody @Validated ArduRegisterRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException("필드 값 오류");
        }

        Member member = memberService.findByUserId(request.getUserId());
        memberService.updateFid(member, request.getFid());
        return ResponseEntity.ok().body(new ResponseDto("fid 업데이트 완료"));
    }
}
