# Observer（观察者模式）

如果你听说过RxJava的话，就应该听说过这种模式。这种模式最大的优点就是将被观察者和观察者解耦，增强了程序的灵活性和可扩展性

那么观察者模式可以运用到什么场景中呢？

举个现实中典型的例子，当你订阅了一份杂志时，就使用了这种模式，你只需要订阅这份杂志，那么只要杂志更新了就会自动送到你的手上。
当然，观察者模式的用途远不止这些，但是处理的事件类型，就类似这种。

对于初学者来说，观察者模式容易混淆的就是一些英文名词了，这里先解释一下，还是拿你订阅杂志这件事来举例：

 + 观察者：Observer，有时候也叫Subscriber(订阅者)，相当于那个订阅杂志的"你"
 + 被观察者：Observable这个单词的意思是可观察的，也就是说可观察的对象被称为被观察者，有时候也叫Subject(主题)，相当于被订阅的杂志

能否理解观察者模式，这两个名词的理解至关重要!

## Observer（观察者模式）的UML类图

![观察者模式](https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/observer.png)

 + Subject：主题，被观察者
 + ConcreteSubject：具体的被观察者
 + Observer：观察者
 + ConcreteObserver：具体的观察者

在上面的 UML 类图中，可以看到 Subject 与 Observer 有一个相互操作的过程。在观察者模式中，观察者只需要实现一个订阅操作，当主题或者被观察者有了什么变化，只需要通过一个修改操作就可以使所有的观察者得到相应，颇有一种"牵一发而动全身"的意思。

下面看一下类图的实现细节
首先是 Subject 主题接口
```java
public interface Subject {

    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers();

}
```
在主题内部有增、删、改三个方法，下面看一下 Observer 观察者接口
```java
public interface Observer {

    void update();

}
```
观察者只需要提供一个 `update()` 方法即可，用于当被观察者有更新时可以给被观察者提供一个对观察者的更新操作

下面就是具体的观察者和具体的主题实现了

观察者实现具体的更新操作
```java
public class ConcreteObserver implements Observer{
    @Override
    public void update() {
        // TODO : update Observer
    }
}
```

被观察者实现对观察者的增、删、改过程
```java
public class ConcreteSubject implements Subject {

    List<Observer> observers;

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
```

以上，基本概念介绍完了。下面就要开始实现一个自己的观察者模式了

## 观察者模式的简单实现

这里就拿 "订阅杂志" 的例子来实现吧

其中：

 + 主题/被观察者：杂志社
 + 订阅者/观察者：订阅杂志的人

首先是先抽象出观察者
```java
public interface Observer {
    /*所有的观察者都必须实现update()方法，以实现观察者接口*/
    public void update(String magazine);
}
```

其次就是主题
```java
public interface Subject {
    /*这两个方法都需要观察者作为变量，该观察者是用来注册或被删除的*/
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    /*当主题状态改变时，这个方法会被调用，以通知所有的观察者*/
    public void notifyObservers();
}
```

然后就是具体的 订阅者/观察者 和 具体的主题/被观察者 ：

订阅者/观察者
```java
public class Subscriber implements Observer {

    private String subscriber;
    private Subject magazine;

    public Subscriber(Subject magazine, String subscriber) {
        this.magazine = magazine;
        magazine.registerObserver(this);
        this.subscriber = subscriber;
    }

    @Override
    public void update(String magazine) {
        System.out.println("亲爱的" + subscriber + ": 你的杂志已到，今日杂志名为《" + magazine +"》");
    }
}
```

主题/被观察者：杂志社
```java
public class Magazine implements Subject {

    private List<Observer> observerList;
    private String magazine;

    public Magazine() {
        observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observerList.size(); i++) {
            Observer observer = observerList.get(i);
            observer.update(magazine);
        }
    }

    public void setMagazine(String magazine) {
        this.magazine = magazine;
        notifyObservers();
    }
}
```
可以看到，这里实现了观察者的订阅，移除和修改，并且通过一个setter方法，让外部可以传递需要修改的内容

测试一下：
```java
Magazine magazine = new Magazine();

Subscriber wang = new Subscriber(magazine, "小王");
Subscriber li = new Subscriber(magazine, "小李");
Subscriber ming = new Subscriber(magazine, "小明");

magazine.setMagazine("震惊！今天的杂志既然. . .");
```

结果
```console
亲爱的小王: 你的杂志已到，今日杂志名为《震惊！今天的杂志既然. . .》
亲爱的小李: 你的杂志已到，今日杂志名为《震惊！今天的杂志既然. . .》
亲爱的小明: 你的杂志已到，今日杂志名为《震惊！今天的杂志既然. . .》
```

如果根据业务分析，发现其实不只有个体才会订阅杂志，一些书店也会订阅杂志社的杂志

这是只需要重新定义一个Bookstore类实现Observer接口，然后根据自己的逻辑实现自己的update方法
```java
public class Bookstore implements Observer {

    private Subject magazine;

    public Bookstore(Subject magazine) {
        this.magazine = magazine;
        magazine.registerObserver(this);
    }

    @Override
    public void update(String magazine) {
        System.out.println("本店今日更新杂志：《" + magazine+ "》");
    }
}
```

测试的时候只需要一句话就可以了
```java
Bookstore bookstore = new Bookstore(magazine);
```

效果就不测试啦~

## 利用Java自带的Observable接口和Observer接口实现观察者模式

其实在Java内部也是内置了Observable接口和Observer接口的，可见观察者模式的重要性

java.util下的Observable类
```java
public class Observable {
    // . . .
    public synchronized void addObserver(Observer o) { . . . }
    public synchronized void deleteObserver(Observer o) { . . . }
    public void notifyObservers() { . . . }
    public void notifyObservers(Object arg) { . . . }
    protected synchronized void setChanged() { . . . }
    protected synchronized void clearChanged() { . . . }
    public synchronized boolean hasChanged() { . . . }
    public synchronized int countObservers() { . . . }
}
```

相比自己的写的Observable来说官方的自然更加全面，并且每个方法都设置为同步的，同时除了添加，删除，修改观察者的几个方法外，还有诸如设置内容改变，获得观察者数量等方法，这里只是描述了个大概，具体的实现细节，可以查看源码

再来看看同包下的Observer类
```java
public interface Observer {
    void update(Observable o, Object arg);
}
```

跟之前自己实现的差不多，但是这里除了需要传递一个内容参数(arg)之外，还需要传递一个被观察者对象

官方的实现介绍完了，试试如何借助官方的实现来实现自己的观察者模式案例

主题/被观察者：杂志社
```java
public class Magazine extends Observable {

    public void notify(String magazine) {
        /*需要标识内容发生修改*/
        setChanged();
        /*修改所有观察者*/
        notifyObservers(magazine);
    }
}
```

这里要注意的是，Observabe下有两个notifyObservers方法，这里要调用那个带参数的那一个，若你调用了不带参数的那一个，实际上也是调用的带参数的那个方法，但是参数传入的是null

对比之前自己实现的观察者模式来说，继承了Java自带的Observable实现起来更加简洁

下面看看 订阅者/观察者
```java
public class Subscriber implements Observer{

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("亲爱的" + name + ": 你的杂志已到，今日杂志名为《" + arg +"》");
    }
}
```

测试
```java
Magazine magazine = new Magazine();

Subscriber wang = new Subscriber("小王");
Subscriber li = new Subscriber("小李");
Subscriber ming = new Subscriber("小明");

magazine.addObserver(wang);
magazine.addObserver(li);
magazine.addObserver(ming);

magazine.notify("震惊！今天的杂志既然. . .");
```

和之前的相比，要注意这里的观察者是需要自己手动添加到被观察中的

测试结果跟之前的是一样的，如果要实现多种观察者的实现(如书店等)，原理是一样的

END.