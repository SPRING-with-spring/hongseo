package com.study.springcore.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private Long id;
    private String name;
    private String username; // 회원 아이디를 의미
    private String password;
}
