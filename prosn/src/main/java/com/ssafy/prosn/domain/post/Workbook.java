package com.ssafy.prosn.domain.post;

import com.ssafy.prosn.domain.user.User;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * created by seongmin on 2022/07/19
 * updated by seongmin on 2022/08/08
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@Getter

public class Workbook extends Post {


    @Builder
    public Workbook(String title, User user) {
        super(title, user);
    }

    //    @OneToMany(mappedBy = "workbook")
//    private List<ProblemWorkbook> problemWorkbooks = new ArrayList<>();
}
