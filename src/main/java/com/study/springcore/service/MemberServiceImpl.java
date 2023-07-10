package com.study.springcore.service;

import com.study.springcore.domain.Member;
import com.study.springcore.dto.JoinReq;
import com.study.springcore.dto.MemberRes;
import com.study.springcore.service.rank.RankingPolicy;
import com.study.springcore.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final RankingPolicy rankingPolicy;


    @Override
    public void join(JoinReq request) {
        Member member = Member.makeMember(request);
        memberRepository.save(member);
    }

    @Override
    public MemberRes login(String username, String password) {
        Member member = memberRepository.findByUsername(username);

        if (member.getPassword().equals(password)) {
            return Member.toDto(member);
        } else {
            return null;
        }
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
