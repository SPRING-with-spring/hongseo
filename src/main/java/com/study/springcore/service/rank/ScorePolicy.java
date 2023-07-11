package com.study.springcore.service.rank;

import com.study.springcore.domain.Member;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ScorePolicy implements RankingPolicy{

    @Override
    public Integer score(Member member, ArrayList<Member> members) {
        List<Member> sortedMembers= members.stream()
                .sorted(Comparator.comparing(Member::getScore)).toList();
        int i = 0;
        while(true){
            if(Objects.equals(sortedMembers.get(i).getId(), member.getId()))
                break;
            i++;
        }
        return ++i;
    }
}