package com.vladdumbrava.marquez_library.service.dtomapper;

import com.vladdumbrava.marquez_library.dto.MemberDTO;
import com.vladdumbrava.marquez_library.model.Member;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class MemberDTOMapper implements Function<Member, MemberDTO> {
    @Override
    public MemberDTO apply(Member member) {
        return new MemberDTO(
                member.getId(),
                member.getName(),
                member.getEmail(),
                member.getPhoneNumber(),
                member.getRegistrationDate(),
                member.getSubscriptionType()
        );
    }
}
