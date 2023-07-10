package com.study.springcore.repository;

import com.study.springcore.domain.Member;

import java.util.ArrayList;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);

    ArrayList<Member> findAll();
}
