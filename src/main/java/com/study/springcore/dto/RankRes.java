package com.study.springcore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(name = "회원 등수")
@AllArgsConstructor
public class RankRes {
    @Schema(name = "등수", example = "1")
    int rank;
}
