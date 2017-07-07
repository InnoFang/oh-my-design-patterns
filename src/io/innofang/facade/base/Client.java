package io.innofang.facade.base;

/**
 * Created by Inno Fang on 2017/7/5.
 */
public class Client {

    public static void main(String[] args) {

        Facade facade = new Facade();
        facade.operationA();
        facade.operationB();
        facade.operationC();

    }

}
