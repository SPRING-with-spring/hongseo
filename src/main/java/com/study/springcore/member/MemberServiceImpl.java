package com.study.springcore.member;

import com.study.springcore.rank.RankingPolicy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final RankingPolicy rankingPolicy;


    @Override
    public void join(Member member) {
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
