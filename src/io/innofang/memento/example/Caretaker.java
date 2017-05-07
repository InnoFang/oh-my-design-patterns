package io.innofang.memento.example;

/**
 * Created by Inno Fang on 2017/3/15.
 */
public class Caretaker {

    private Memento mMemoto;

    public void archive(Memento memoto) {
        mMemoto = memoto;
    }

    public Memento getMemoto() {
        return mMemoto;
    }
}
