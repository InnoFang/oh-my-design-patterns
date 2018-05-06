package io.innofang.visitor.base;

/**
 * Created by Inno Fang on 2018/5/6.
 */
public class ConcreteVisitorB implements Visitor {
    @Override
    public void visitElementA(Element elementA) {
        System.out.println("ConcreteVisitorB visit elementA: " + elementA);
    }

    @Override
    public void visitElementB(Element elementB) {
        System.out.println("ConcreteVisitorB visit elementB: " + elementB);
    }
}
