package com.study.springcore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Schema(name = "로그인")
@Data
public class LoginReq {
    @Schema(name = "아이디", example = "peaceB")
    @NotBlank
    private String username; // 회원 아이디를 의미

    @Schema(name = "비밀번호", example = "password123")
    @NotBlank
    private String password;
}
