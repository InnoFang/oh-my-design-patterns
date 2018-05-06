package io.innofang.visitor.base;

/**
 * Created by Inno Fang on 2018/5/6.
 */
public class ConcreteVisitorA implements Visitor {
    @Override
    public void visitElementA(Element elementA) {
        System.out.println("ConcreteVisitorA visit elementA: " + elementA);
    }

    @Override
    public void visitElementB(Element elementB) {
        System.out.println("ConcreteVisitorA visit elementB: " + elementB);
    }
}
