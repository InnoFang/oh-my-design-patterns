package io.innofang.template_method.base;

/**
 * Created by Inno Fang on 2017/5/8.
 */
public class AbsTemplate {

    protected void stepOne() {
        System.out.println("Step One");
    }

    protected void stepTwo() {
        System.out.println("Step Two");
    }

    protected void stepThree() {
        System.out.println("Step Three");
    }

    public final void execute(){
        stepOne();
        stepTwo();
        stepThree();
    }
}
