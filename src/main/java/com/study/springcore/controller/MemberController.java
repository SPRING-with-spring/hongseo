package com.study.springcore.controller;

import com.study.springcore.ResponseEntity;
import com.study.springcore.StatusEnum;
import com.study.springcore.dto.MemberReq;
import com.study.springcore.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "member 관리 API")
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "회원가입", description = "멤버를 생성합니다.")
//    @Parameter(name = "str", description = "2번 반복할 문자열")
    @PostMapping("/join")
    public ResponseEntity<Long> join(@ModelAttribute MemberReq member) {
        memberService.join(member);
        return ResponseEntity.res(StatusEnum.OK);
    }
}
