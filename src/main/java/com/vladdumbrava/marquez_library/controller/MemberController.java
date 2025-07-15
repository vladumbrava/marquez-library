package com.vladdumbrava.marquez_library.controller;

import com.vladdumbrava.marquez_library.dto.MemberDTO;
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
    public void createMember(@RequestBody Member member) {
        memberService.createMember(member);
    }

    @GetMapping
    public List<MemberDTO> getAllMembers() {
        return memberService.getAllMembers();
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable("id") Long id) {
        memberService.deleteMember(id);
    }

    @PutMapping("/{id}")
    public void updateMember(@PathVariable("id") Long id, @RequestBody Member newMember) {
        memberService.updateMember(id, newMember);
    }

    @PatchMapping("/{id}")
    public void updateMemberName(@PathVariable("id") Long id, @RequestBody String newName) {
        memberService.updateMemberName(id, newName);
    }

}
