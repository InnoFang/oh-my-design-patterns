package io.innofang.memento.base;

/**
 * Created by Inno Fang on 2017/5/7.
 */
public class Client {

    public static void main(String[] args) {
        Originator originator = new Originator(1);
        Caretaker caretaker = new Caretaker();
        caretaker.storeMemoto(originator.createMemoto());
        originator.restore(caretaker.restoreMemoto());
    }

}
