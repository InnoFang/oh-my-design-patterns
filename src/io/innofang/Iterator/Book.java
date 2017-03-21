package io.innofang.Iterator;

/**
 * Created by Inno Fang on 2017/3/20.
 */
public class Book {

    private String name;    /* 书名 */
    private String ISBN;    /* ISBN号 */
    private String press;   /* 出版社 */

    public Book(String name, String ISBN, String press) {
        this.name = name;
        this.ISBN = ISBN;
        this.press = press;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", press='" + press + '\'' +
                '}';
    }

    // getter and setter
}
