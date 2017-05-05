package io.innofang.decorator.base;

/**
 * Created by Inno Fang on 2017/5/4.
 */
public abstract class Decorator implements Component{

    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}
