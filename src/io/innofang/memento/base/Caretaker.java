package io.innofang.memento.base;

/**
 * Created by Inno Fang on 2017/5/7.
 */
public class Caretaker {

    private Memoto memoto;

    public void storeMemoto(Memoto memoto) {
        this.memoto = memoto;
    }

    public Memoto restoreMemoto() {
        return memoto;
    }

}
