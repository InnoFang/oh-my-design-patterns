package io.innofang.visitor.base;

/**
 * Created by Inno Fang on 2018/5/6.
 */
public class ElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitElementA(this);
    }


}
