package io.innofang.state.base;

/**
 * Created by Inno Fang on 2017/5/8.
 */
public class Context {

    State state;

    public void request() {
        state.handle();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void handleByA() {
        setState(new ConcreteStateA());
    }

    public void handleByB() {
        setState(new ConcreteStateB());
    }

    public static void main(String[] args) {
        Context context = new Context();
        context.handleByA();
        context.request();

        context.handleByB();
        context.request();

    }
}
