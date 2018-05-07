package io.innofang.visitor.example;

import io.innofang.visitor.base.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inno Fang on 2018/5/7.
 *
 * 人才市场
 */
public class LaborMarket {

    List<Applicant> applicants = new ArrayList<>();

    {
        applicants.add(new Student("Wang",  3.2, "Computer Science"));
        applicants.add(new Student("Lee",  3.4, "Network Engineer"));
        applicants.add(new Student("Chan",  3.4, "Computer Science"));
        applicants.add(new Engineer("Bob",  4, 15));
        applicants.add(new Engineer("Tony",  3, 10));
        applicants.add(new Engineer("Jim",  6, 20));
    }


    public void showApplicants(Interviewer visitor) {
        for (Applicant applicant : applicants) {
            applicant.accept(visitor);
        }
    }
}
