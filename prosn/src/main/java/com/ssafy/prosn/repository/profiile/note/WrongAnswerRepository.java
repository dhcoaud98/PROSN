package com.ssafy.prosn.repository.profiile.note;

import com.ssafy.prosn.domain.post.Problem;
import com.ssafy.prosn.domain.profile.note.WrongAnswer;
import com.ssafy.prosn.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * created by seongmin on 2022/07/29
 */
public interface WrongAnswerRepository extends JpaRepository<WrongAnswer, Long> {

    List<WrongAnswer> findByUser(User user);
    void deleteById(Long id);
    boolean existsByUserAndProblem(User user, Problem problem);
}
