package io.innofang.visitor.base;

/**
 * Created by Inno Fang on 2018/5/6.
 */
public class Client {

    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.accept(new ConcreteVisitorA());
        objectStructure.accept(new ConcreteVisitorB());
    }

}
