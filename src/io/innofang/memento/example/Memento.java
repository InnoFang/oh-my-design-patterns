package io.innofang.memento.example;

/**
 * Created by Inno Fang on 2017/3/15.
 */
public class Memento {
    private String mDate;
    private String mTodo;
    private boolean mIsFinish;

    public void setDate(String date) {
        mDate = date;
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

    public boolean isFinish() {
        return mIsFinish;
    }

    public void setIsFinish(boolean mIsFinish) {
        this.mIsFinish = mIsFinish;
    }

    @Override
    public String toString() {
        return "memento{" +
                "Date='" + mDate + '\'' +
                ", Todo='" + mTodo + '\'' +
                ", IsFinish=" + mIsFinish +
                '}';
    }
}
