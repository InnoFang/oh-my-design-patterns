package io.innofang.Iterator;

/**
 * Created by Inno Fang on 2017/3/20.
 */
public class LiteratureIterator implements Iterator {
    /* 用数组存储文学类书籍 */
    private Book[] literatures;
    /* 数组下标 */
    private int index;

    public LiteratureIterator(Book[] literatures) {
        this.literatures = literatures;
    }

    @Override
    public boolean hasNext() {
        /* 当前位置没有越界并且当前位置有书，则返回true */
        return (index < literatures.length - 1 && literatures[index] != null);
    }

    @Override
    public Book next() {
        return literatures[index++];
    }
}
