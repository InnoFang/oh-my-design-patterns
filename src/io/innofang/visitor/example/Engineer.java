package io.innofang.visitor.example;

/**
 * Created by Inno Fang on 2018/5/7.
 *
 * 申请者：工程师，具有姓名，工作经验，项目数量，并实现 accept 方法，用于接收面试官审核
 */
public class Engineer implements Applicant {

    private String name;
    private int workExperience;
    private int projectNumber;

    public Engineer(String name, int workExperience, int projectNumber) {
        this.name = name;
        this.workExperience = workExperience;
        this.projectNumber = projectNumber;
    }

    @Override
    public void accept(Interviewer visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public int getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(int projectNumber) {
        this.projectNumber = projectNumber;
    }
}
