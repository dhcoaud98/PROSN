package com.ssafy.prosn.repository.user;

import com.ssafy.prosn.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
