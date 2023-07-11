package com.study.springcore.service.rank;

import com.study.springcore.domain.Member;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Component
public class GradePolicy implements RankingPolicy{

    @Override
    public Integer score(Member member, ArrayList<Member> members) {
        List<Member> sortedMembers= members.stream()
                .sorted(Comparator.comparing(Member::getGrade)).toList();
        int i = 0;
        while(true){
            if(Objects.equals(sortedMembers.get(i).getId(), member.getId()))
                break;
            i++;
        }
        return ++i;
    }
}
