package io.innofang.visitor.example;

/**
 * Created by Inno Fang on 2018/5/7.
 *
 * 对于 HR 而言，考察学生时考察的是专业，而工程师则是工作经验
 */
public class Hr implements Interviewer {
    @Override
    public void visit(Student student) {
        System.out.println("Student  " + student.getName() + "'s major is " + student.getMajor());
    }

    @Override
    public void visit(Engineer engineer) {
        System.out.println("Engineer  " + engineer.getName() + "'s work experience is " + engineer.getWorkExperience() + " year");
    }
}
