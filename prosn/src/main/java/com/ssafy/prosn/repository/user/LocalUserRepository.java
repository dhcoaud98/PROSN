package com.ssafy.prosn.repository.user;

import com.ssafy.prosn.domain.user.LocalUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * created by seongmin on 2022/07/20
 * updated by seongmin on 2022/07/27
 */
public interface LocalUserRepository extends JpaRepository<LocalUser, Long> {
    Optional<LocalUser> findByUserId(String uid);
    boolean existsByEmail(String email);

    boolean existsByUserId(String userId);
}
