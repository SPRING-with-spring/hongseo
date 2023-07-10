package com.study.springcore.domain;

import com.study.springcore.dto.JoinReq;
import com.study.springcore.dto.MemberRes;
import lombok.*;

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

    public static Member makeMember(JoinReq request) {
        Member member = new Member();
        member.name = request.getName();
        member.username = request.getUsername();
        member.password = request.getPassword();
        return member;
    }

    public static MemberRes toDto(Member member) {
        return new MemberRes(member.getId(), member.getName(), member.getUsername());
    }
}
