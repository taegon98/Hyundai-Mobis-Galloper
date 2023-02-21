package com.server.api.controller;

import com.server.api.ResponseDto;
import com.server.api.dto.ardu.FingerPrintRequest;
import com.server.api.dto.manager.ManagerSignUpRequest;
import com.server.api.dto.manager.MemberListResponse;
import com.server.api.dto.member.StatusResponse;
import com.server.domain.Manager;
import com.server.domain.Member;
import com.server.exception.MethodArgumentNotValidException;
import com.server.service.ManagerService;
import com.server.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    public ResponseEntity saveManager(@RequestBody @Validated ManagerSignUpRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException("필드 값 오류");
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

        List<Member> members = managerService.findMembers(manager);    //관리자 찾기
        List<MemberListResponse> memberListResponses = members.stream().map(MemberListResponse::toDTO).collect(Collectors.toList());
        /*
        해당 관리자가 관리하고있는 회원들의 정보를 반환
        -> 정보 : 아이디, 부모 이름, 부모 번호, 자녀 이름
         */
        return ResponseEntity.ok().body(memberListResponses);
    }

    @PostMapping("/fpregister/geton/{token}")
    public ResponseEntity getOn(@PathVariable String token) {
        Member member = memberService.findByTokenId(token);

        managerService.updateStatus(member, true);
        return ResponseEntity.ok().body(new StatusResponse(true));
    }

    @PostMapping("/fpregister/getoff/{token}")
    public ResponseEntity getOff(@PathVariable String token) {
        Member member = memberService.findByTokenId(token);

        managerService.updateStatus(member,false);
        return ResponseEntity.ok().body(new StatusResponse(false));
    }

    @PostMapping("/fpreregister/geton")
    public void getOnByFp(@RequestBody @Validated FingerPrintRequest request, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            throw new MethodArgumentNotValidException("fid 값이 존재 하지 않음");
        }
        Member member = memberService.findByFid(request.getFid());  //해당 fid값을 가지고있는 회원이 있다면
        managerService.updateStatus(member,true);   //해당 회원의 상태를 승차로 변경

        return;
    }
}
