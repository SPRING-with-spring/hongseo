package com.study.springcore.controller;

import com.study.springcore.ResponseEntity;
import com.study.springcore.SessionConst;
import com.study.springcore.StatusEnum;
import com.study.springcore.dto.JoinReq;
import com.study.springcore.dto.LoginReq;
import com.study.springcore.dto.MemberRes;
import com.study.springcore.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "member 관리 API")
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "회원가입", description = "멤버를 생성합니다.")
//    @Parameter(name = "str", description = "2번 반복할 문자열")
    @PostMapping("/join")
    public ResponseEntity<String> join(@Valid @RequestBody JoinReq member) {
        memberService.join(member);
        return ResponseEntity.res(StatusEnum.OK, "empty");
    }

    @Operation(summary = "로그인", description = "멤버의 아이디와 비밀번호가 일치할 경우 로그인을 할 수 있습니다.")
    @PostMapping("/login")
    public ResponseEntity<MemberRes> login(@Valid @RequestBody LoginReq member, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.res(StatusEnum.BAD_REQUEST);
        }

        MemberRes loginMember = memberService.login(member.getUsername(), member.getPassword());
        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호 맞지 않습니다.");
            return ResponseEntity.res(StatusEnum.BAD_REQUEST);
        }

        //로그인 성공 처리
        //세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성
        HttpSession session = request.getSession();
        //세션에 로그인 회원 정보 보관
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return  ResponseEntity.res(StatusEnum.OK, loginMember);
    }

    @Operation(summary = "로그아웃")
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        //세션이 현재 있으면 반환하고, 없으면 반환하지 말아라
        HttpSession session = request.getSession(false);
        if (session != null) {
            log.info("session delete");
            session.invalidate();
        }
        return ResponseEntity.res(StatusEnum.OK, "empty");
    }


}
