# Flyweight (享元) 模式

享元模式，作用于会产生大量对象的场景，其实现原理是使用缓存，避免创建过多的、重复的对象并提升程序性能。

简单来说，当我们需要一个对象时，一般都是使用 new 来创建一个对象。但是实际情况却是，如果在一段时间内有大量的请求的话，就会产生大量的对象，可是这些对象的内容都大同小异，如果反复的创建、销毁对象，必将影响程序的性能。而享元模式的作用就是用来解决这个问题的。

其实在这里关于缓存的实现可以理解为对“池”的实现，我们都知道，在 String 类中有常量池，在线程中有线程池，它们的作用都是避免创建过多的对象以达到提升性能的目的。所以，在享元模式中，我们将实现一个对象池。一个经典的实现就是使用键值对（ Map ）。我们以对象之间相同的部分（内在状态）作为键，以不同的部分（外在状态）作为值，当我们从持有缓存的享元工厂中获取享元对象的时候，先判断时候存在我们需要的键，若没有则创建一个新的对象放入缓存中，若存在则使用缓存的对象，以此来达到避免创建过多对象的目的。

# Flyweight (享元) 模式的 UML 类图

![flyweight pattern](https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/flyweight.png)

+ Flyweight: 享元对象接口或抽象类
+ ConcreteFlyweight: 具体的享元对象
+ FlyweightFactory: 享元工厂，负责管理享元对象池和创建享元对象

简单的看一下实现：

首先是定义一个享元对象接口：Flyweight
```java
public interface Flyweight {

    public void operation(String extrinsicState);

}
```

这里要传入的参数就是该享元对象的外部状态 (Extrinsic State)，即享元对象间根据情况的不同而会变化的部分

接着是实现了接口的具体的享元对象：ConcreteFlyweight
```java
public class ConcreteFlyweight implements Flyweight{

    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println(intrinsicState + " : " + extrinsicState);
    }
}
```

这里的全局变量就是该享元对象的内部状态 (Intrinsic State)，即享元对象间不会随着使用情况的不同而变化的部分

最后就是实现享元工厂：FlyweightFactory
```java
public class FlyweightFactory {

    private static Map<String, Flyweight> map = new ConcurrentHashMap<>();

    public static Flyweight getFlyweight(String key) {
        if (map.containsKey(key)) {
            System.out.println("use cache:");
            return map.get(key);
        } else {
            System.out.println("create new:");
            Flyweight flyweight = new ConcreteFlyweight(key);
            map.put(key, flyweight);
            return flyweight;
        }
    }

}
```

在这一块使用 Map 集合来缓存对象，在获取享元对象的时候会判断是否存在该对象的缓存，若存在则直接获取，否则就创建一个新的对象。这里为了显示这两部分的效果，输出了中间结果

那么接下来就是测试一下
```java
Flyweight flyweight1 = FlyweightFactory.getFlyweight("key1");
flyweight1.operation("value1");
Flyweight flyweight2 = FlyweightFactory.getFlyweight("key1");
flyweight2.operation("value2");
Flyweight flyweight3 = FlyweightFactory.getFlyweight("key1");
flyweight3.operation("value3");
```

测试结果如下
```console
create new:
key1 : value1
use cache:
key1 : value2
use cache:
key1 : value3
```

可见，在使用除了第一次使用需要创建对象之外，接下来获取该 key 的对象的时候都不需要创建对象

# 享元模式的简单实现下

正如上面所说，享元模式适用于可能存在大量重复对象的场景，所以，诸如订票系统这类例子。因为同一类型的票会产生很多份，那么对应的重复对象的创建和销毁就会产生，这将导致程序性能下降和内存占用率的上升

接下来就以订购电影票为例子。

