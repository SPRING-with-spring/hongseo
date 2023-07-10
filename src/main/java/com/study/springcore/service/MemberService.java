package com.study.springcore.service;

import com.study.springcore.domain.Member;
import com.study.springcore.dto.MemberReq;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;

public interface MemberService {
    void join(MemberReq request);

//    void login(Member member, BindingResult bindingResult, HttpServletRequest request);
//
//    void logout(Member member, HttpServletRequest request);
//
    Member findMember(Long memberId);

    ArrayList<Member> findAll();

    int calculateRank(Member member);
}
