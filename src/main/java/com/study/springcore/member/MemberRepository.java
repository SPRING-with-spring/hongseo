package com.study.springcore.member;

import java.util.ArrayList;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);

    ArrayList<Member> findAll();
}
