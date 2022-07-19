package com.ssafy.prosn.domain.post;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * created by seongmin on 2022/07/19
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@Getter
public class Workbook extends Post {

    @OneToMany(mappedBy = "workbook")
    private List<ProblemWorkbook> problemWorkbooks = new ArrayList<>();
}
