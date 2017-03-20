package io.innofang.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Inno Fang on 2017/3/20.
 */
public class Test {

    public static void main(String[] args) {
        /* 创建List容器*/
        List<Integer> list = new ArrayList<>();
        /* 添加数据*/
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        /* 迭代容器 */
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
