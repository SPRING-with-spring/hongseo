package com.study.springcore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Schema(name = "멤버 요청에 따른 응답")
@Data
public class MemberRes {

    @Schema(name = "아이디", example = "1")
    private Long memberId;

    @Schema(name = "이름(실명)", example = "홍길동")
    private String name;

    @Schema(name = "아이디", example = "peaceB")
    private String username;
}
