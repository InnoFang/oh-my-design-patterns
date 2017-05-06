package io.innofang.iterator.base;

/**
 * Created by Inno Fang on 2017/5/6.
 */
public interface Aggregate<T> {

    void add(T obj);

    void remove(T obj);

    Iterator<T> iterator();

}
