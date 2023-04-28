package com.study.springcore.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Member {
    public Member(Long id, String name, int score, int grade, int percentile) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.grade = grade;
        this.percentile = percentile;
    }

    private  Long id;
    private  String name;
    private int score;
    private int grade;
    private int percentile;
    private int rank;
}
