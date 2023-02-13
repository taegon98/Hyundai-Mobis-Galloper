package com.server.service;

import com.server.domain.Member;
import com.server.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void join() {
        Member member = new Member();
        member.register("test","test","123","01012345678");
        member.register("test2","test2","123","01012345678");

        memberRepository.save(member);
    }

    @Test
    void findOne() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findByUserId() {
    }

    @Test
    void findByTokenId() {
    }
}