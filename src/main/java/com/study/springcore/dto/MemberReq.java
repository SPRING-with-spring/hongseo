package com.study.springcore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Schema(name = "회원가입 멤버 요청")
@Data
public class MemberReq {

    @Schema(name = "이름(실명)", example = "홍길동")
    private String name;

    @Schema(name = "아이디", example = "peaceB")
    @NotBlank
    private String username; // 회원 아이디를 의미

    @Schema(name = "비밀번호", example = "password123")
    @NotBlank
    private String password;
}
