package io.innofang.Iterator;

/**
 * Created by Inno Fang on 2017/3/20.
 */
public class QueryTest {

    public static void main(String[] args) {
        /* 创建文学类书籍容器 */
        Literature literature = new Literature();
        /* 迭代文学类书籍容器 */
        itr(literature.iterator());

        System.out.println("\n+----------Divider----------+\n");

        /* 创建编程类书籍容器 */
        Programming programming = new Programming();
        /* 迭代编程类书籍容器 */
        itr(programming.iterator());
    }

    /* 书籍容器共有的迭代方法 */
    private static void itr(Iterator iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
