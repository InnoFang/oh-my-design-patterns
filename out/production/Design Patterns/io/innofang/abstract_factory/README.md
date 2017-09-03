# Abstract Factory（抽象工厂）

在此之前，已经学习过了<a href="https://github.com/InnoFang/DesignPatterns/tree/master/src/io/innofang/factory_method">Factory Method（工厂方法）</a>，抽象工厂和工厂方法这两个模式都属于创建型设计模式，那么根据[工厂]这个词，大概也能猜出这两个模式都是用来“生产”的

那么这两种用来“生产”的模式 ——— 抽象工厂和工厂方法，这两个设计模式有什么区别呢？或者说也两个模式“生产”的东西有什么不同的吗？

在之前工厂方法的简单实现中，举了个工厂制作蛋糕的例子，那么现在我们的蛋糕店需要生产两种蛋糕，分别为草莓口味的红色的爱心型蛋糕和芒果口味的黄色的方形蛋糕，这两个都是具体的产品，换句话说，对于草莓味心型蛋糕，心型模具和草莓味奶油都是只用来生产这类蛋糕的，那如果我们想做一个爱心型的芒果蛋糕呢？难道还要做一个只属于芒果蛋糕的模具吗？

不，当然不是，在日常生活中，对于这种情况，应该是拿一个爱心模具来做一类爱心型蛋糕，而不会说一种蛋糕做一个模具

到这里，或许对于抽象工厂和工厂方法的区别还是有点模糊

那么，现在来总结一下，

 + 如果是用来生成一个复杂的对象，他的内部元素无法抽象出来时，选择**工厂方法模式**
 + 如果是用来生产具体细节抽象的产品，产品的内部元素可变，选择**抽象工厂**

说了这么多，但是还没有见到抽象模式的真身，下面先介绍一下抽象工厂模式，然后，再重新打造我们的工厂，让其能够生产更多类型的蛋糕

# Abstract Factory（抽象工厂）的UML类图

![](https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/abstract_factory.png)

 + AbstractProductA：抽象产品A
  - ConcreteProductA1：具体产品A1
  - ConcreteProductA2：具体产品A2
 + AbstractProductB：抽象产品B
  - ConcreteProductB1：具体产品B1
  - ConcreteProductB2：具体产品B2
 + AbstractFactory：抽象工厂，内部有两个方法，分别用来生产不同的产品，最后成一个整体
  - ConcreteFactory1：具体工厂1
  - ConcreteFactory2：具体工厂2


先创建产品的抽象类
AbstractProductA
```java
public abstract class AbstractProductA {
    public abstract void doA();
}
```

AbstractProductB
```java
public abstract class AbstractProductB {
    public abstract void doB();
}
```

然后再来打造具体的产品细节
ConcreteProductA1
```java
public class ConcreteProductA1 extends AbstractProductA {
    @Override
    public void doA() {
        System.out.println("Concrete Product A 1");
    }

}
```

ConcreteProductA2
```java
public class ConcreteProductA2 extends AbstractProductA {
    @Override
    public void doA() {
        System.out.println("Concrete Product A 2");
    }

}
```

ConcreteProductB1
```java
public class ConcreteProductB1 extends AbstractProductB {
    @Override
    public void doB() {
        System.out.println("Concrete Product B 1");
    }

}
```

ConcreteProductB2
```java
public class ConcreteProductB2 extends AbstractProductB {
    @Override
    public void doB() {
        System.out.println("Concrete Product B 2");
    }

}
```

OK，关于具体的产品细节已经做好了，现在最关键的就是通过工厂，来将这些细节组装成一个具体的产品

首先，在打造一个抽象工厂

AbstractFactory
```java
public abstract class AbstractFactory {
    // 生产产品细节A
    public abstract AbstractProductA createProductA();
    // 生产产品细节B
    public abstract AbstractProductB createProductB();
}
```

好了，接下来就是根据需要打造具体的工厂了
ConcreteFactory1：生产产品细节A1和产品细节B2
```java
public class ConcreteFactory1 extends AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB2();
    }
}
```

ConcreteFactory2：生产产品细节A2和产品细节B1
```java
public class ConcreteFactory2 extends AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }
}
```

好了，现在我们只需要通过这两个工厂，就能得到一个具有A和B两种不同细节的产品

# 抽象工厂模式的简单实现

还是挺简单的，那么，接下来，借助上面的经验，是时候将蛋糕店好好装修一番了，让蛋糕店可以生产各种各样的产品

首先，分析一下，对于蛋糕

 + 按照造型分，我们有爱心型的和方形的，
 + 按照奶油分，我们有红色的草莓味和黄色的芒果味

那么根据调查发现(是我瞎说的~)，现在爱心型的草莓味蛋糕和芒果味的方形蛋糕是卖的最火的，所以，蛋糕店也需要与时俱进，将要生产这种两种蛋糕

好了，分析完了，我们先根据造型，打造一个抽象造型产品(或者说是蛋糕模板也可以啦~)

抽象造型产品
```java
public abstract class CakeStyle {
    public abstract void style();
}

```

再根据奶油，打造一个抽象奶油产品

抽象奶油产品
```java
public abstract class CakeCream {
    public abstract void cream();
}
```
OK，下面分别开始制作爱心型模板，方形模板，草莓味奶油，芒果味奶油

爱心型模板
```java
public class HeartStyle extends CakeStyle {
    @Override
    public void style() {
        System.out.println("Heart Style");
    }
}
```
方形模板
```java
public class SquareStyle extends CakeStyle {
    @Override
    public void style() {
        System.out.println("Square Style");
    }
}
```

草莓味奶油
```java
public class StrawberryCream extends CakeCream {
    @Override
    public void cream() {
        System.out.println("Strawberry Cream");
    }
}
```

芒果味奶油
```java
public class MangoCream extends CakeCream {
    @Override
    public void cream() {
        System.out.println("Mango Cream");
    }
}
```


现在，无论是材料还是工具都做好了，只要根据需要，通过具体的工厂生产就行了

首先，还是来一个抽象工厂
```java
public abstract class CakeFactory {

    public abstract CakeCream cream();

    public abstract CakeStyle style();
}

```

然后，就分别是爱心型草莓味蛋糕工厂和方形芒果味蛋糕工厂

爱心型草莓味蛋糕工厂
```java
public class StrawberryHeartCake extends CakeFactory{
    @Override
    public CakeCream cream() {
        return new StrawberryCream();
    }

    @Override
    public CakeStyle style() {
        return new HeartStyle();
    }
}

```

方形芒果味蛋糕工厂
```java
public class MangoSquareCake extends CakeFactory {
    @Override
    public CakeCream cream() {
        return new MangoCream();
    }

    @Override
    public CakeStyle style() {
        return new SquareStyle();
    }
}

```

大功告成，让我们来看看蛋糕做得怎么样
```java
 public static void main(String[] args) {
        CakeFactory strawberryHeartCake = new StrawberryHeartCake();
        strawberryHeartCake.cream().cream();
        strawberryHeartCake.style().style();

        System.out.println();

        CakeFactory mangoSquareCake = new MangoSquareCake();
        mangoSquareCake.cream().cream();
        mangoSquareCake.style().style();
 }
```

result:
```console
Strawberry Cream
Heart Style

Mango Cream
Square Style

```

还不赖嘛~

如果，这时需求变更了，比如，现在更流行吃爱心型芒果味蛋糕

那么我们只需要一个工厂就可以做 到了，而不需要再去重头开始制作奶油和模板

爱心型芒果味蛋糕
```java
public class MangoHeartCake extends CakeFactory {
    @Override
    public CakeCream cream() {
        return new MangoCream();
    }

    @Override
    public CakeStyle style() {
        return new HeartStyle();
    }
}
```

还是挺简单的嘛~

好了，来总结一下抽象工厂的优缺点吧

 + 优点：最明显的分离了抽象和实现，基于产品的抽象和实现的分离，是抽象工厂在切换产品类时更加灵活和容易
 + 缺点：就像我们上面看到的，一个产品就需要一个工厂，那么根据产品的越来越多，具体工厂类就越来越多；另一个就是不容易扩展，比如现在有了新的需求，比如蛋糕现在生产时有了磅数(重量)的要求，那么我们就必须去修改抽象工厂类，从而导致所有的具体工厂类都必须修改