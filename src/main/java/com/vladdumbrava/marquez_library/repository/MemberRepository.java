package com.vladdumbrava.marquez_library.repository;

import com.vladdumbrava.marquez_library.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
