package com.study.springcore.service;

import com.study.springcore.domain.Member;
import com.study.springcore.dto.JoinReq;
import com.study.springcore.dto.MemberRes;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;

public interface MemberService {
    void join(JoinReq request);

    MemberRes login(String loginId, String password);
//
//    void logout(Member member, HttpServletRequest request);
//
    Member findMember(Long memberId);

    ArrayList<Member> findAll();

    int calculateRank(Member member);
}
