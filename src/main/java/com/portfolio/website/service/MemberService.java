package com.portfolio.website.service;

import com.portfolio.website.domain.Member;
import com.portfolio.website.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member findOne(Long memberId) {
        return memberRepository.findById(memberId).get();
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findById(id).get();
        member.setName(name);
    }

    @Transactional
    public void join(Member member) {
        memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> findMember = memberRepository.findById(member.getId());

        if(findMember != null)
            throw new IllegalStateException("Member already exists");
    }
}
