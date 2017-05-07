package io.innofang.memento.example;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Inno Fang on 2017/3/15.
 */
public class ToDo {
    private String mDate;
    private String mTodo;
    private boolean mIsFinish;

    public ToDo() {
        mDate = new SimpleDateFormat("yyyy/MM/dd EE HH:mm:ss").format(new Date());
    }

    public void setToDoDetail(String todo, boolean isFinish) {
        mTodo = todo;
        mIsFinish = isFinish;
    }

    public Memento createMemoto() {
        Memento memento = new Memento();
        memento.setDate(mDate);
        memento.setTodo(mTodo);
        memento.setIsFinish(mIsFinish);
        return memento;
    }

    public void restore(Memento memento) {
        mDate = memento.getDate();
        mTodo = memento.getTodo();
        mIsFinish = memento.isFinish();
    }

    public String getDate() {
        return mDate;
    }

    public String getTodo() {
        return mTodo;
    }

    public void setTodo(String mTodo) {
        this.mTodo = mTodo;
    }

    public boolean isIsFinish() {
        return mIsFinish;
    }

    public void setIsFinish(boolean mIsFinish) {
        this.mIsFinish = mIsFinish;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "Date='" + mDate + '\'' +
                ", Todo='" + mTodo + '\'' +
                ", IsFinish=" + mIsFinish +
                '}';
    }
}
