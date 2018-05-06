package io.innofang.visitor.base;

/**
 * Created by Inno Fang on 2018/5/6.
 */
public interface Element {
    void accept(Visitor visitor);
}
