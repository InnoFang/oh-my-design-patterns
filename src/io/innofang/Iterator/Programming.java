package io.innofang.Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inno Fang on 2017/3/20.
 */
public class Programming implements BookIterable {

    private List<Book> programmings;

    public Programming() {
        programmings = new ArrayList<>();
        programmings.add(new Book("C++编程思想", "9787111091622", "机械工业出版社"));
        programmings.add(new Book("Java编程思想", "9787111213826", "机械工业出版社"));
        programmings.add(new Book("Effective Java", "9787111113850", "机械工业出版社"));
        programmings.add(new Book("计算机网络自顶向下方法", "9787111165057", "机械工业出版社"));
        programmings.add(new Book("Head First 设计模式（中文版）", "9787508353937", "中国电力出版社"));
    }

    public List<Book> getProgrammings() {
        return programmings;
    }

    @Override
    public Iterator iterator() {
        return new ProgrammingIterator(programmings);
    }
}
