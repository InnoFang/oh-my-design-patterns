package io.innofang.iterator.example;

/**
 * Created by Inno Fang on 2017/3/20.
 */
public class Literature implements BookIterable {

    private Book[] literature;

    public Literature() {
        literature = new Book[4];
        literature[0] = new Book("三国演义", "9787532237357", "上海人民美术出版社");
        literature[1] = new Book("西游记", "9787805200552", "岳麓书社");
        literature[2] = new Book("水浒传", "9787020015016", "人民文学出版社");
        literature[3] = new Book("红楼梦", "9787020002207", "人民文学出版社");
    }

    public Book[] getLiterature() {
        return literature;
    }

    @Override
    public Iterator iterator() {
        return new LiteratureIterator(literature);
    }
}
