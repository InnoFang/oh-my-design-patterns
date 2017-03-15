package io.innofang.Memento;

/**
 * Created by Inno Fang on 2017/3/15.
 */
public class Client {

    public static void main(String[] args) {
        // 创建备忘录
        ToDo toDo = new ToDo();
        // 下午两点写Java，未完成
        toDo.setToDoDetail("Write Java at 2 pm", false);
        // 创建备忘录本子，用于存储备忘录
        Caretaker caretaker = new Caretaker();
        caretaker.archive(toDo.createMemoto());
        // 查看备忘细节
        System.out.println(toDo.toString());
        // 重新拿一份备忘录，并恢复之前的备忘细节，并标注任务已完成
        ToDo newToDo = new ToDo();
        newToDo.restore(caretaker.getMemoto());
        newToDo.setIsFinish(true);
        // 查看备忘细节
        System.out.println(newToDo.toString());
    }
}
