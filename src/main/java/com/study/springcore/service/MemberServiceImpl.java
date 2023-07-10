package com.study.springcore.service;

import com.study.springcore.domain.Member;
import com.study.springcore.dto.MemberReq;
import com.study.springcore.service.rank.RankingPolicy;
import com.study.springcore.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final RankingPolicy rankingPolicy;


    @Override
    public void join(MemberReq request) {
        Member member = Member.makeMember(request);
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    @Override
    public ArrayList<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public int calculateRank(Member member) {
        return rankingPolicy.score(member, findAll());
    }
}
