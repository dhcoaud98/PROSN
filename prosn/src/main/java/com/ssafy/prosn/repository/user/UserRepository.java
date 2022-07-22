package com.ssafy.prosn.repository.user;

import com.ssafy.prosn.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * created by seongmin on 2022/07/20
 * updated by seongmin on 2022/07/22
 */
public interface UserRepository extends JpaRepository<User, Long> {

    // user를 point 내림차순으로 조회
    @Query("SELECT u FROM User u order by point desc")
    List<User> findRanking();

    /**
     * todo : point 랭킹 탑 5 조회
     * hack : spring data jpa 로 메서드 생성했더니 안됨..
     *        JPQL 쿼리로 했더니 JPQL 에서는 limit 안됨..
     */
//    @Query("SELECT u FROM User u order by point desc limit 5")
//    List<User> findTop5ByIdOrderByPointDesc();
}
