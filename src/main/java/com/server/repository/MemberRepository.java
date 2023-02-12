package com.server.repository;

import com.server.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    //회원 단건 조회 by PK
    Member findMemberById(Long id);

    //회원 단건 조회 by TOKEN
    Member findMemberByToken(String token);

    //회원 단건 조회 by USERID
    Member findMemberByUserId(String userId);

    //전체 회원 조회
    List<Member> findMembersById(Long id);

    //중복 ID 검사
    boolean existsByUserId(String userId);
}
