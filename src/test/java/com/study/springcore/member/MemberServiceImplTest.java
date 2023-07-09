package com.study.springcore.member;

import com.study.springcore.AutoConfiguration;
import com.study.springcore.domain.Member;
import com.study.springcore.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class MemberServiceImplTest {

    @Test
    void calculateRank(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoConfiguration.class);
        MemberService memberService = applicationContext.getBean(MemberService.class);
        Member member1 = new Member(1L, "user1", 100, 1, 98);
        Member member2 = new Member(2L, "user2", 58, 4, 60);
        Member member3 = new Member(2L, "user2", 80, 2, 85);
        Member member4 = new Member(2L, "user2", 76, 3, 70);
        memberService.join(member1);
        memberService.join(member2);
        memberService.join(member3);
        memberService.join(member4);

        Assertions.assertThat(memberService.calculateRank(member3)).isEqualTo(2);
    }

}