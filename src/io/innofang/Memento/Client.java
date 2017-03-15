package io.innofang.Memento;

/**
 * Created by Inno Fang on 2017/3/15.
 */
public class Client {

    public static void main(String[] args) {
        ToDo toDo = new ToDo();
        toDo.setToDoDetail("Write Java at 2 pm", false);

        Caretaker caretaker = new Caretaker();
        caretaker.archive(toDo.createMemoto());

        System.out.println(toDo.toString());

        ToDo newToDo = new ToDo();
        newToDo.restore(caretaker.getMemoto());
        newToDo.setIsFinish(true);
        System.out.println(newToDo.toString());
    }
}
