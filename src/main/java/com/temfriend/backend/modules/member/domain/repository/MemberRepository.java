package com.temfriend.backend.modules.member.domain.repository;

import com.temfriend.backend.modules.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
