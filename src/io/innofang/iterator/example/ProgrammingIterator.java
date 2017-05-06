package io.innofang.iterator.example;

import java.util.List;

/**
 * Created by Inno Fang on 2017/3/20.
 */
public class ProgrammingIterator implements Iterator {
    /* 用数组存储文学类书籍 */
    private List<Book> programmings;
    /* 下标 */
    private int index;

    public ProgrammingIterator(List<Book> programmings) {
        this.programmings = programmings;
    }

    @Override
    public boolean hasNext() {
        return (index < programmings.size() - 1 && programmings.get(index) != null);
    }

    @Override
    public Book next() {
        return programmings.get(index++);
    }
}
