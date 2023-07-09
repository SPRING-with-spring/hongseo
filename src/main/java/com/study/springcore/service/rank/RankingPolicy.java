package com.study.springcore.service.rank;

import com.study.springcore.domain.Member;

import java.util.ArrayList;

public interface RankingPolicy {
    int score(Member member, ArrayList<Member> members);
}
