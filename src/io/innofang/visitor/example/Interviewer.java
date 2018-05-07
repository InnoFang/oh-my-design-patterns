package io.innofang.visitor.example;

/**
 * Created by Inno Fang on 2018/5/6.
 *
 * 面试官接口，分对象考核学生和工程师
 */
public interface Interviewer {

    void visit(Student student);
    void visit(Engineer engineer);

}
