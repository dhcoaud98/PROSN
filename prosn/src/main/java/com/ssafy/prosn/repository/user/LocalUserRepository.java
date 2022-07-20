package com.ssafy.prosn.repository.user;

import com.ssafy.prosn.domain.user.LocalUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by seongmin on 2022/07/20
 */
public interface LocalUserRepository extends JpaRepository<LocalUser, Long> {
    boolean existsByEmail(String email);

    boolean existsByUserId(String userId);
}
