package com.study.springcore.rank;

import com.study.springcore.member.Member;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class PercentilePolicy implements RankingPolicy{

    @Override
    public int score(Member member, ArrayList<Member> members) {
        List<Member> sortedMembers= members.stream()
                .sorted(Comparator.comparing(Member::getPercentile)).toList();
        int i = 0;
        while(true){
            if(Objects.equals(sortedMembers.get(i).getId(), member.getId()))
                break;
            i++;
        }
        return ++i;
    }
}
