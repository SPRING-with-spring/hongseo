package com.study.springcore.repository;

import com.study.springcore.domain.Member;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private Long id = 0L;

    @Override
    public void save(Member member) {
        member.setId(id);
        store.put(++id, member);
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
