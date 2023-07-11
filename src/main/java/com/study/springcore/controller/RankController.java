package com.study.springcore.controller;

import com.study.springcore.ResponseEntity;
import com.study.springcore.StatusEnum;
import com.study.springcore.dto.JoinReq;
import com.study.springcore.dto.RankReq;
import com.study.springcore.dto.RankRes;
import com.study.springcore.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "점수 관리 API")
@RequestMapping("/rank")
public class RankController {
    private final MemberService memberService;

    @Operation(summary = "점수 등록", description = "회원의 점수를 등록합니다.")
    @PostMapping("/{memberId}")
    public ResponseEntity<String> registerRank(@PathVariable Long memberId, @Valid @RequestBody RankReq rank) {
        memberService.registerRank(memberId, rank);
        return ResponseEntity.res(StatusEnum.OK, "empty");
    }

    @Operation(summary = "회원 등수", description = "회원의 현재 등수를 출력합니다.")
    @GetMapping("/{memberId}")
    public ResponseEntity<RankRes> calculateRank(@PathVariable Long memberId) {
        Integer rank = memberService.calculateRank(memberId);

        if (rank == null) {
            return ResponseEntity.res(StatusEnum.BAD_REQUEST);
        } else {
            return ResponseEntity.res(StatusEnum.OK, new RankRes(rank));
        }
    }
}
