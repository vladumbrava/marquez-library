package com.vladdumbrava.marquez_library.service;

import com.vladdumbrava.marquez_library.model.Member;
import com.vladdumbrava.marquez_library.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    public Member updateMember(Long id, Member newMember) {
        Member updatedMember = memberRepository.findById(id)
                .map(member -> {
                    member.setName(newMember.getName());
                    member.setEmail(newMember.getEmail());
                    member.setPhoneNumber(newMember.getPhoneNumber());
                    member.setRegistrationDate(newMember.getRegistrationDate());
                    member.setSubscriptionType(newMember.getSubscriptionType());
                    return memberRepository.save(member);
                })
                .orElseGet(() -> memberRepository.save(newMember));
        log.info("Updated member with id: {}", updatedMember.getId());
        return updatedMember;
    }

    public Member updateMemberName(Long id, String newName) {
        Member updatedMember = memberRepository.findById(id)
                .map(member -> {
                    member.setName(newName);
                    return memberRepository.save(member);
                })
                .orElseThrow(() -> new EntityNotFoundException("Member not found with id: " + id));
        log.info("Updated name for member with id: {}", id);
        return updatedMember;
    }
}
