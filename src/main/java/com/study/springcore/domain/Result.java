package com.study.springcore.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Long result_id;
    private Long member_id;
    private Integer score;
    private Integer grade;
    private Integer percentile;
}
