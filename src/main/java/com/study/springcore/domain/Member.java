package com.study.springcore.domain;

import com.study.springcore.dto.MemberReq;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private Long id;
    private String name;
    private String username; // 회원 아이디를 의미
    private String password;
    private Integer score;
    private Integer grade;
    private Integer percentile;

    public static Member makeMember(MemberReq request) {
        Member member = new Member();
        member.name = request.getName();
        member.username = request.getUsername();
        member.password = request.getPassword();
        return member;
    }
}
