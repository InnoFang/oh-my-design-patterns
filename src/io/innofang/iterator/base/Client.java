package io.innofang.iterator.base;

/**
 * Created by Inno Fang on 2017/5/6.
 */
public class Client {

    public static void main(String[] args) {
        Aggregate<String> aggregate = new ConcreteAggregate<>();
        aggregate.add("Hello");
        aggregate.add("Android");
        aggregate.add("Bye");
        Iterator<String> iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
