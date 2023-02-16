package com.server.api.controller;

import com.server.api.ResponseDto;
import com.server.api.dto.member.MemberSignUpRequest;
import com.server.domain.Member;
import com.server.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@CrossOrigin
public class MemberApiController {

    private final MemberService memberService;

    //회원등록
    @PostMapping("/save")
    public ResponseEntity saveMember(@RequestBody @Validated MemberSignUpRequest request, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }

        Member member = new Member();

        member.register(request.getName(), request.getUserId(), request.getPassword(), request.getTelephone(), request.getChildName());
        memberService.join(member);

        return ResponseEntity.ok().body(new ResponseDto("회원가입이 완료되었습니다."));
    }
    @PutMapping("/regManager/{id}")
    public ResponseEntity registerManager(@PathVariable String id,
                                          @RequestBody @Validated RegisterManagerRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult);
        }

        Manager findManager = managerService.findByUserId(request.getUserId());
        memberService.updateMember(id, findManager);

        return ResponseEntity.ok().body(new ResponseDto("관리자 등록이 완료되었습니다."));
    }
}
