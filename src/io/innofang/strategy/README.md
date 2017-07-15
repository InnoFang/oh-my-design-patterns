# Strategy（策略模式）

在讲策略模式之前，我们先来讲个例子：

人在广州的小王想出去旅游，此时他面临几个选择

 + 如果是从广州到广西桂林，由于距离适中，他想自己驾车前往
 + 如果是从广州到四川峨嵋，由于距离稍远，他打算乘火车前往
 + 如果是从广州到吉林长春，由于距离太远，他选择坐飞机前往

那么面对这种不同情况的不同处理方式，我们最自然想到的就是使用if-else或者switch-case来解决，
通过判断不同的情况，然后提出对应的处理方式。

但是这样子处理真的没有问题吗？

我们试着按照平常的思维写一下这个例子：

```java
public class Wang {

    private static final String GUI_LIN = "guang_xi_gui_lin";   //广西桂林
    private static final String E_MEI = "guang_xi_gui_lin";     //四川峨嵋
    private static final String CHANG_CHUN = "guang_xi_gui_lin";//吉林长春

    public void takeCar() {
        System.out.println("take my car");
    }

    public void takeTrain() {
        System.out.println("take train");
    }

    public void tekePlane() {
        System.out.println("take plane");
    }

    public void goTo(String place) {
        if (GUI_LIN.equals(place)) {
            takeCar();
        } else if (E_MEI.equals(place)) {
            takeTrain();
        } else if (CHANG_CHUN.equals(place)) {
            tekePlane();
        }
    }

}
```

在客户类中执行操作
```java
public class Client {
    public static void main(String[] args) {
        Wang wang = new Wang();
        wang.goTo(GUI_LIN);
        wang.goTo(E_MEI);
        wang.goTo(CHANG_CHUN);
    }
}
```

似乎没有什么不妥的地方，但是如果小王想改坐轮船从广州去海南呢？

我是不是还得添加一个`takeShip()`方法然后再在goTo方法里面判断一下

如果只是添加一个还好，那如果是添加十个地方呢？那如果小王又想出国呢？

那么如果反复的在这个类里面添加方法和修改条件，会使得这个类越来越脆弱，难以维护，同时也不符合OOP的设计原则

既然如此，面对这种不同情况的不同处理方式，有没有什么好的设计模式可供参考呢？

这就是我们接下来要讲的设计模式了 ———— 策略模式

## Strategy（策略模式）的UML类图

![](https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/strategy.png)


 + Context：用来操作策略的上下文，比如上面讲的小王
 + Strategy：抽象策略类
 + ConcreteStrategy：具体策略实现类

在策略模式中，我们将各个策略都封装起来，在使用策略时是可以相互替换的，这样就将策略实现独立于客户类之外，降低了耦合度

Talk is cheap, show you my code;

## 策略模式的简单实现

下面就来具体实现一下这个策略模式：

那么首先先得有个抽象策略类，用来规范具体策略类
```java
public interface GoToStrategy {
    void transportation();
}
```

然后，就可以实现具体的策略了，根据上面的情况，先实现去桂林，去峨嵋，去长春的三种策略

ConcreteStrategy: GoToGuiLin
```java
public class GoToGuiLin implements GoToStrategy {
    @Override
    public void transportation() {
        System.out.println("take my car");
    }
}
```
ConcreteStrategy: GoToEMei
```java
public class GoToEMei implements GoToStrategy {
    @Override
    public void transportation() {
        System.out.println("take train");
    }
}
```

ConcreteStrategy: GoToChangChun
```java
public class GoToChangChun implements GoToStrategy {
    @Override
    public void transportation() {
        System.out.println("take plane");
    }
}
```

最后，也就是在具体的上下文中使用策略，也就是让小王去使用策略

比如他要去长春
```java
public class Wang {

    private GoToStrategy goToStrategy;

    public void setGoToStrategy(GoToStrategy goToStrategy) {
        this.goToStrategy = goToStrategy;
    }

    private void take() {
        goToStrategy.transportation();
    }
}
```
这时候，Wang这个类就变成了操作和管理策略的类了，具体的该执行什么策略，那么就可以在客户类中像下面这样操作
```java
Wang wang = new Wang();
wang.setGoToStrategy(new GoToChangChun());
wang.take();
```
如果小王改变主意想去峨嵋了，那么只需要更改setStrategy就可以了，其他的都不需要更改

```java
wang.setGoToStrategy(new GoToEMei());
```

那如果，他又想去乘轮船去海南的话，只需要再实现一个策略就可以了

```java
public class GoToHaiNan implements GoToStrategy{
    @Override
    public void transportation() {
        System.out.println("take ship");
    }
}
```

然后再次更改调用 `Wang` 这个类的对象的 `setStrategy()` 方法就可以了

以上就是策略模式的简单实现。还有一点需要强调的是，Wang 这个类在这里是操作策略的上下文，也就是说到底该执行什么策略，是由外部来调用 Wang 的方法来决定的，而不是 Wang 在类内部来决定的

## 总结

我们来总结一下策略模式的优缺点：

 + 优点：
   - 结构清晰明了，使用简单直观
   - 耦合度相对而言较低，方便管理
   - 操作封装也更为彻底，数据更为安全
 + 缺点：
   - 随着策略的增加，子类也会变得繁多

END.