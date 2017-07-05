package io.innofang.facade.uml;

/**
 * Created by Inno Fang on 2017/7/5.
 */
public class Facade {

    private SubSystemA subSystemA;
    private SubSystemB subSystemB;
    private SubSystemC subSystemC;

    public Facade() {
        this.subSystemA = new SubSystemA();
        this.subSystemB = new SubSystemB();
        this.subSystemC = new SubSystemC();
    }

    public void operationA() {
        subSystemA.exec();
    }

    public void operationB() {
        subSystemB.exec();
    }

    public void operationC() {
        subSystemC.exec();
    }

}
