package io.innofang.visitor.example;

/**
 * Created by Inno Fang on 2018/5/7.
 *
 * 面试申请者接口，只有一个抽象方法用来接受面试官的考核
 */
public interface Applicant {
    void accept(Interviewer visitor);
}
