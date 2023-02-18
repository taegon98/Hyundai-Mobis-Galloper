package com.server.service;

import com.server.domain.Manager;
import com.server.domain.Member;
import com.server.repository.MemberRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Null;
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

    //로그인 검증
    public Member Login(String userId, String password) {
        Member findMember = memberRepository.findMemberByUserId(userId);

        if (findMember.getPassword().equals(password)) return findMember;
        else return null;
    }

    //회원 정보 업데이트 (관리자 등록)
    @Transactional
    public void updateMember(String userId, Manager manager) {
        Member findMember = memberRepository.findMemberByUserId(userId);

        findMember.registerManager(manager);
    }

    @Transactional
    public void updateFid(Member member, int fid) {
        member.registerFingerprint(fid);
        return;
    }
    //회원 단건 조회 by FID
    public Member findByFid(int fid) {return memberRepository.findMemberByFid(fid); }
}

