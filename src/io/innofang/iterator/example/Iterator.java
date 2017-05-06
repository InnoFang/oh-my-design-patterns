package io.innofang.iterator.example;

/**
 * Created by Inno Fang on 2017/3/20.
 */
public interface Iterator<T> {

    boolean hasNext();

    T next();

}
