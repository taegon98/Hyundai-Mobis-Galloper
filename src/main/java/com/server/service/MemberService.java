package com.server.service;

import com.server.domain.Member;
import com.server.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //회원가입
    @Transactional
    public Long join(Member member) {

        validateDuplicateUserId(member);    //아이디 중복 검사
        memberRepository.save(member);

        return member.getId();
    }

    //아이디 중복 검사
    private void validateDuplicateUserId(Member member) {
        boolean usernameDuplicate = memberRepository.existsByUserId(member.getUserId());
        if (usernameDuplicate) {
            throw new IllegalStateException("동일한 아이디가 이미 존재합니다.");
        }
    }

    //회원 단건 조회 by PK
    public Member findOne(Long id) {
        return memberRepository.findMemberById(id);
    }

    //전체 회원 조회
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    //회원 단건 조회 by USERID
    public Member findByUserId(String userId) {
        return memberRepository.findMemberByUserId(userId);
    }

    //회원 단건 조회 by TOKEN
    public Member findByTokenId(String token) {
        return memberRepository.findMemberByToken(token);
    }
}

