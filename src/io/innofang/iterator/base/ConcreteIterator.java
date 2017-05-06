package io.innofang.iterator.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inno Fang on 2017/5/6.
 */
public class ConcreteIterator<T> implements Iterator<T> {

    private List<T> list;
    private int cursor = 0;

    public ConcreteIterator(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return cursor != list.size();
    }

    @Override
    public T next() {
        T obj = null;
        if (hasNext()) {
            obj =  list.get(cursor++);
        }
        return obj;
    }

}
