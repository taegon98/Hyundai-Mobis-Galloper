package com.server.service;

import com.server.domain.Manager;
import com.server.domain.Member;
import com.server.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ManagerServiceTest {

    @Autowired
    private ManagerService managerService;

    @DisplayName("관리자 회원가입 테스트")
    @Test
    void 회원가입() {
        Manager manager1 = new Manager();
        Manager manager2 = new Manager();

        manager1.register("test","test","test","01012345678");
        manager2.register("test2","test2","test2","0101234678");

        managerService.join(manager1);   //회원가입 테스트
        managerService.join(manager2);
    }

    @DisplayName("관리자 조회 테스트")
    @Test
    void 회원조회() {
        Manager manager1 = new Manager();
        Manager manager2 = new Manager();

        manager1.register("test","test","test","01012345678");
        manager2.register("test2","test2","test2","0101234678");

        Long findManager1 = managerService.join(manager1);//회원가입 테스트
        Long findManager2 = managerService.join(manager2);

        Manager findManager = managerService.findOne(findManager1);
        //findById 테스트 (pk)
        Assertions.assertThat(findManager).isEqualTo(manager1);

        //findByToken 테스트
        Assertions.assertThat(managerService.findByTokenId(findManager.getToken())).isEqualTo(findManager);

        //findByUserId 테스트
        Assertions.assertThat(managerService.findByUserId(findManager.getUserId())).isEqualTo(findManager);
    }

    @DisplayName("관리자 중복 아이디 검증 테스트")
    @Test
    void 중복아이디검증() {
        Manager manager1 = new Manager();
        Manager manager2 = new Manager();

        manager1.register("test","test","test","01012345678");
        manager2.register("test","test","test","0101234678");

        managerService.join(manager1);

        org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, () -> {
            managerService.join(manager2);    //중복 아이디 검증 테스트
        });
    }

    @DisplayName("관리자 로그인 테스트")
    @Test
    void 로그인() {
        Manager manager = new Manager();

        manager.register("test","test","1234","01012345678");
        managerService.join(manager);

        Assertions.assertThat(managerService.Login("test","1234")).isEqualTo(manager);
    }
}