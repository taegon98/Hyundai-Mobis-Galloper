package com.server.api.dto.manager;

import com.server.domain.Manager;
import com.server.domain.Member;
import lombok.Data;

import java.util.List;

@Data
public class MemberListResponse {
    private String name;
    private String userId;
    private String telephone;
    private String childName;

    public MemberListResponse(Member member) {
        this.name = member.getName();
        this.userId = member.getUserId();
        this.telephone = member.getTelephone();
        this.childName = member.getChildName();
    }

    public static MemberListResponse toDTO(Member member) {
        return new MemberListResponse(member);
    }
}
