package io.innofang.template_method.base;

/**
 * Created by Inno Fang on 2017/5/8.
 */
public class Client {

    public static void main(String[] args) {
        AbsTemplate template = new ConcreteTemplate();
        template.execute();
    }

}
