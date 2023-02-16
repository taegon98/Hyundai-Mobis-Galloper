package com.server.api.controller;

import com.server.api.ResponseDto;
import com.server.api.dto.manager.ManagerSignUpRequest;
import com.server.api.dto.manager.MemberListResponse;
import com.server.api.dto.member.MemberSignUpRequest;
import com.server.domain.Manager;
import com.server.domain.Member;
import com.server.service.ManagerService;
import com.server.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/manager")
@RequiredArgsConstructor
@CrossOrigin
public class ManagerApiController {

    private final ManagerService managerService;
    private final MemberService memberService;

    //관리자 회원가입
    @PostMapping("/save")
    public ResponseEntity saveManager(@RequestBody @Validated ManagerSignUpRequest request, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }
        Manager manager = new Manager();

        manager.register(request.getName(), request.getUserId(), request.getPassword(), request.getTelephone());
        managerService.join(manager);

        return ResponseEntity.ok().body(new ResponseDto("회원가입이 완료되었습니다."));
    }

    //관리자에게 속한 일반회원들 반환
    @GetMapping("/members/{token}")
    public ResponseEntity getMembers(@PathVariable String token) {
        Manager manager = managerService.findByTokenId(token);

        List<Member> members = managerService.findMembers(manager);
        List<MemberListResponse> memberListResponses = members.stream().map(MemberListResponse::toDTO).collect(Collectors.toList());

        return ResponseEntity.ok().body(memberListResponses);
    }

    @PostMapping("/getoff/{token}")
    public ResponseEntity getOff(@PathVariable String token) {
        Member member = memberService.findByTokenId(token);

        member.getOff();
        return ResponseEntity.ok().body(new ResponseDto("하차 완료"));
    }
}
