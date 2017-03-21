# Iterator (迭代器模式)

其实在平常的开发当中，迭代器模式是被经常使用的，举个例子，比如使用迭代器遍历结合
```java
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
```

如此看来，开发者对于迭代器模式应该还是比较熟悉的，而迭代器的作用也的确如此 ———— 遍历一个容器对象。

下面来看一下迭代器模式UML的类图

## Iterator (迭代器模式)的UML类图

![](http://my.csdn.net/uploads/201204/02/1333348153_6748.jpg)

 + Aggregate : 容器接口
 + ConcreteAggregate : 具体容器类
 + Iterator : 迭代器接口
 + ConcreteIterator : 具体的迭代器接口

那么迭代器模式在一个自定义的容器中是如何使用的呢？、

我们在使用迭代器模式的时候，是先从容器中获得迭代器对象的，当获得迭代器对象后，在利用迭代器的 `hasNext()` 方法来判断是否有下一个元素，当结果为 `true` 时，再利用 `next()` 方法返回下一个数据，以此来达到遍历结合的目的

如果这一块不熟悉，可以看一下上面的例子来加深理解

## 迭代器模式的简单实现

来一个例子：如果假设现在图书馆新进了一批书，现在你需要遍历查找这些新进的书是否有自己想要的

当然，如果只是创建一个 `Book` 的实体类，然后再创建一个 `Book` 类型的 `List` 集合，然后遍历这个 `List` 集合，似乎问题并没有那么复杂，但是，在实际开发当中，事情往往没有那么简单

因为将书细分下来还有很多的分类类：文学类，科技类，编程类等，因此，如果只是将这些书用一个容器保存就欠妥了

那如果使用多个集合呢？似乎问题也能解决，但是在实际开发当中，往往是协同开发

举个例子，如果A的工作是建立图书的存储功能，B是建立图书的查询功能，那么这时B对A所建立的容器是不熟悉的，那么这时他该如何决定遍历容器的方式呢？

这就是问题所在，这时利用迭代器模式，A在自己的存储功能中，实现对自己容器的迭代方式，并对外暴露迭代器创建的方法(**注意** 迭代方式和容器是分离，容器只持有一个返回迭代器对象的方法)，这样当B实现查询功能时，只需要用一套迭代器查询方法就可以了。

由此看出，迭代器模式的优点就是降低了容器与迭代算法的耦合

经过上述分析，那么就来简单实现一下这个案例吧，建立一个文学类书籍容器和编程类书籍容器，然后利用迭代器模式进行遍历

首先先来创建一个迭代器接口
```java
public interface Iterator<T> {

    boolean hasNext();

    T next();

}
```
这个迭代器的功能很简单，就两个方法

 + `boolean hasNext();` 是否有下一个元素
 + `T next()` 返回下一个元素

这里要提一点的就是，Java也有一个 `Iterator` 接口

在 `java.util` 包下，简单看一下内部代码
```java
public interface Iterator<E> {

    boolean hasNext();

    E next();

    default void remove() {
        throw new UnsupportedOperationException("remove");
    }

    default void forEachRemaining(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
    }
}
```

可以看到官方的 `Iterator` 内部还多了两个默认方法，分别用于删除容器元素和遍历容器元素

所以这里继承哪一个 `Iterator` 都是可以的， 这里采用自己定义的 `Iterator`

既然要实现两个书籍容器，为了体现迭代器模式的优势，这里将文学类书籍的存储方式设置为数组存储，将变成类书籍的存储方式设置为List存储

实现文学类书籍迭代器
```java
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
```

实现编程类书籍迭代器
```java
public class ProgrammingIterator implements Iterator {
    /* 用数组存储文学类书籍 */
    private List<Book> programmings;
    /* 下标 */
    private int index;

    @Override
    public boolean hasNext() {
        return (index < programmings.size() - 1 && programmings.get(index) != null);
    }

    @Override
    public Book next() {
        return programmings.get(index++);
    }
}
```

接下来需要考虑容器，根据分析，这里需要两个容器，在此之前需要先定义书的实体类(因为书的属性基本一致，所以这里共有一个实体类)

书籍实体类
```java
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
```

下面创建容器接口，作用是使子类去实现一个返回特定的迭代对象的方法
```java
public interface BookIterable<T> {

    Iterator<T> iterator();

}
```

与 `Iterator` 相对应的，Java 也有一个 Iterable 接口，并且集合接口 `Collection` 继承了这个接口

官方的 `Iterator` 接口
```java
public interface Iterable<T> {

    Iterator<T> iterator();

    default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }

    default Spliterator<T> spliterator() {
        return Spliterators.spliteratorUnknownSize(iterator(), 0);
    }
}
```

_默认方法的功能有兴趣的可以自己去查，这里暂且不提_

实现 `BookIterable` 接口实现文学类书籍容器
```java

```