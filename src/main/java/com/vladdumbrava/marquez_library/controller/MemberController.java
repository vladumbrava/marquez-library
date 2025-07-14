package com.vladdumbrava.marquez_library.controller;

import com.vladdumbrava.marquez_library.model.Member;
import com.vladdumbrava.marquez_library.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable("id") Long id) {
        memberService.deleteMember(id);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable("id") Long id, @RequestBody Member newMember) {
        return memberService.updateMember(id, newMember);
    }

    @PatchMapping("/{id}")
    public Member updateMemberName(@PathVariable("id") Long id, @RequestBody String newName) {
        return memberService.updateMemberName(id, newName);
    }

}
