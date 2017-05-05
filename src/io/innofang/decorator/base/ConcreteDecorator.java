package io.innofang.decorator.base;

/**
 * Created by Inno Fang on 2017/5/4.
 */
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("Add decorator operation 1");
        super.operation();
        System.out.println("Add decorator operation 2");
    }
}
