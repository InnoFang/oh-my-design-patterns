package io.innofang.Decorator.base;

/**
 * Created by Inno Fang on 2017/5/4.
 */
public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("This is Concrete Component");
    }
}
