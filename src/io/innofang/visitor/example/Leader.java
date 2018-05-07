package io.innofang.visitor.example;

/**
 * Created by Inno Fang on 2018/5/7.
 *
 * 对于 Leader 而言，考量学生时他想考察的是 GPA，而对工程师的话则是项目数量
 */
public class Leader implements Interviewer {
    @Override
    public void visit(Student student) {
        System.out.println("Student  " + student.getName() + "'s gpa is " + student.getGpa());
    }

    @Override
    public void visit(Engineer engineer) {
        System.out.println("Engineer  " + engineer.getName() + "'s number of projects is " + engineer.getProjectNumber());
    }
}
