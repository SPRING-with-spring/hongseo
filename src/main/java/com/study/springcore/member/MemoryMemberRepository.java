package com.study.springcore.member;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

    @Override
    public ArrayList<Member> findAll() {
        ArrayList<Member> all = new ArrayList<>();
        for (Long i : store.keySet()) {
            all.add(store.get(i));
        }
        return all;
    }
}
