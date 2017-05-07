package io.innofang.memento.base;

/**
 * Created by Inno Fang on 2017/5/7.
 */
public class Originator {

    private int state;

    public Originator(int state) {
        this.state = state;
    }

    public Memoto createMemoto() {
        Memoto memoto = new Memoto();
        memoto.setState(state);
        return memoto;
    }

    public void restore(Memoto memoto){
        this.state = memoto.getState();
    }

}
