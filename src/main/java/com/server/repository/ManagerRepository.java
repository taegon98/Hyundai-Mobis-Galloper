package com.server.repository;

import com.server.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

    //관리자 단건 조회 by PK
    Manager findMemberById(Long id);

    //관리자 단건 조회 by TOKEN (car_serial #)
    Manager findMemberByToken(String token);

    //관리자 단건 조회 by USERID
    Manager findMemberByUserId(String userId);

    //중복 ID 검사
    boolean existsByUserId(String userId);
}
