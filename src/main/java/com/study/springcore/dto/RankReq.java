package com.study.springcore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "회원 점수")
public class RankReq {
    @Schema(name = "점수", example = "98")
    private Integer score;
    @Schema(name = "등급", example = "1")
    private Integer grade;
    @Schema(name = "백분위", example = "99")
    private Integer percentile;
}
