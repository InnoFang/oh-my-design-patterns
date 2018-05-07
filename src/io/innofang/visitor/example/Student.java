package io.innofang.visitor.example;

/**
 * Created by Inno Fang on 2018/5/7.
 *
 * 申请者：学生，具有姓名，gpa，专业属性，并实现 accept 方法，用于接收面试官审核
 */
public class Student implements Applicant {

    private String name;
    private double gpa;
    private String major;

    public Student(String name, double gpa, String major) {
        this.name = name;
        this.gpa = gpa;
        this.major = major;
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


    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
