package com.server.service;

import com.server.domain.Member;
import com.server.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @DisplayName("회원가입 테스트")
    @Test
    void 회원가입() {
        Member member1 = new Member();
        Member member2 = new Member();

        member1.register("test", "test", "test", "test","01012345678");
        member2.register("test2", "test2", "test2", "test","0101234678");

        memberService.join(member1);   //회원가입 테스트
        memberService.join(member2);
    }

    @DisplayName("회원 조회 테스트")
    @Test
    void 회원조회() {
        Member member1 = new Member();
        Member member2 = new Member();

        member1.register("test", "test", "test", "test","01012345678");
        member2.register("test2", "test2", "test2", "test","0101234678");

        Member findMember1 = memberRepository.save(member1);    //회원가입 테스트
        Member findMember2 = memberRepository.save(member2);

        //findByToken 테스트
        Assertions.assertThat(memberRepository.findMemberByToken(findMember1.getToken())).isEqualTo(member1);
        //findById 테스트 (pk)
        Assertions.assertThat(memberRepository.findMemberById(findMember1.getId())).isEqualTo(member1);
        //findByUserId 테스트
        Assertions.assertThat(memberRepository.findMemberByUserId(findMember1.getUserId())).isEqualTo(member1);
        //findAll 테스트
        Assertions.assertThat(memberRepository.findAll().size()).isEqualTo(2);
    }

    @DisplayName("중복 아이디 검증 테스트")
    @Test
    void 중복아이디검증() {
        Member member1 = new Member();
        Member member2 = new Member();

        member1.register("test","test","test","test","01012345678");
        member2.register("test","test","test","test","0101234678");

        memberService.join(member1);

        org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);    //중복 아이디 검증 테스트
        });
    }

    @DisplayName("로그인 테스트")
    @Test
    void 로그인() {
        Member member = new Member();

        member.register("test","test","1234","01012345678");
        memberService.join(member);

        Assertions.assertThat(memberService.Login("test","1234")).isEqualTo(member);
    }
}