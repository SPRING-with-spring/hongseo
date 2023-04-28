package com.study.springcore.rank;

import com.study.springcore.member.Member;

import java.util.ArrayList;

public interface RankingPolicy {
    int score(Member member, ArrayList<Member> members);
}
