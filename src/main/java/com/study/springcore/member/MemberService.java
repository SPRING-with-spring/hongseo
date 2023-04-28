package com.study.springcore.member;

import java.util.ArrayList;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);

    ArrayList<Member> findAll();

    int calculateRank(Member member);
}
