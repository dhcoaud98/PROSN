package com.ssafy.prosn.repository.user;

import com.ssafy.prosn.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by seongmin on 2022/07/20
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
