package com.study.springcore.service.rank;

import com.study.springcore.domain.Member;

import java.util.ArrayList;

public interface RankingPolicy {
    Integer score(Member member, ArrayList<Member> members);
}
