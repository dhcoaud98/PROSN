package com.ssafy.prosn.repository.user;

import com.ssafy.prosn.domain.user.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialUserRepository extends JpaRepository<SocialUser, Long> {
}
