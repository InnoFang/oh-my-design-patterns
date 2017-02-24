# Factory Method（工厂方法）

工厂，顾名思义是用来生产东西的，那么在平常Coding的过程中，能用在什么地方呢？

在任何需要生成复杂对象的地方都可以使用工厂模式，当然，如果只是用new就可以创建的对象就没必要使用工厂模式了

## Factory Method（工厂方法）的UML类图

![](http://img.my.csdn.net/uploads/201204/02/1333347948_2280.jpg)

如上图

 + Product：产品类接口，用于规范产品类
 + ConcreteProduct：具体的产品类
 + Creator：抽象的工厂方法
 + ConcreteCreator：工厂方法的具体实现类，用于生产具体的产品

 Talk is cheap, show you my code.

首先先定义产品类接口

```java
public interface Product {
    void method();
}
```

然后，接着定义两个具体产品类A和B

A
```java
public class A implements Product{

    @Override
    public void do() {
        System.out.println("Hi, I'm product A!");
    }
}
```

B
```java
public class B implements Product{

    @Override
    public void do() {
        System.out.println("Hi, I'm product B!");
    }
}
```

那么分别对应于产品A和B，就要有对应的工厂A和工厂B
在此之前先定义一个抽象的工厂类
```java
public abstract class Factory {

    public abstract Product createProduct();
}
```

工厂A
```java
public class FactoryA extends Factory {

    @Override
    public Product createProduct() {
        return new A(); // create the product A
    }
}
```

工厂B
```java
public class FactoryB extends Factory {

    @Override
    public Product createProduct() {
        return new B(); // create the product B
    }
}
```

OK，我们来测试一下
```java
Factory factoryA = new FactoryA(); // create factory A
Product productA = factoryA.createProduct();
productA.do();

Factory factoryB = new FactoryA(); // create factory B
Product productB = factoryB.createProduct();
productB.do();

```

Result：
`
Hi, I'm product A!
Hi, I'm product B!
`

但是，难道我们们每一个产品都要创建一个对应的产品工厂吗？一两个产品还好，但是如果是10个呢？50个呢？

这样一来，都会多出很多的类，使得工程更加的冗余

所以在这里，我们完全可以利用反射来减少代码量

为了达成目的，我们首先就需要对抽象工厂做出修改，具体实现如下
```java
public abstract class Factory {
    public abstract <T extends Product> T createProduct(Class<T> clz);
}
```

从上面的代码中可以看出，我们需要让传入一个类，然后经过操作返回一个具体的产品

所以核心就是如何实现这个具体工厂，接着往下看

现在修改具体工厂实现，

```java
public class ConcreteFactory extends Factory {

    @Override
    public <T exdents Product> T createProduct(Class<T> clz) {
        Product product = null;
        try {
            product = (Product) Class.forName(clz.getName()).newInstance();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
```

这里我们通过利用了反射机制，通过传入具体产品类名来获得对应产品类实例，从而我们只需要这一个具体工厂实例，大大减少了代码量

现在我们再来测试一下
```java
Factory factory = new ConcreteFactory();
Product productA = factory.createProduct(ProductA.class);
productA.do();

Factory factory = new ConcreteFactory();
Product productB = factory.createProduct(ProductB.class);
productB.do();
```

测试结果同上面一样

经过上面的编码，可以发现工厂方法模式大大降低了对象之间的耦合度，这种依赖抽象的架构具有非常好的可扩展性

好，上面只是简单讲解，下面来一个工厂方法的简单实现

这里我们以制作蛋糕为例

因为蛋糕有各种各样的口味和造型，所以在制作的过程中就需要区别对待了

那么现在蛋糕店需要生产两种类型的蛋糕，分别是红色的草莓蛋糕和黄色的芒果蛋糕

那么了解了需求过后我们利用刚学的工厂方法模式来完成需求吧~

首先我们就可以定义一个蛋糕接口
```java
public interface Cake {
    void cakeColor(); // 蛋糕的颜色
    void cakeStyle(); // 蛋糕的造型
}
```

好，现在该规划我们需要什么颜色和什么造型的蛋糕了，对于草莓蛋糕，根据需求，我们的是红色的爱心型的蛋糕

```java
public class Strawberry implements Cake{

    @Override
    public void cakeColor() {
        System.out.println("The cake's color is red.");
    }

    @Override
    public void cakeStyle() {
        System.out.println("The cake's style is heart-snaped.");
    }
}
```

那么对于芒果蛋糕呢，我们需要的是黄色的，呈正方形的芒果蛋糕
```java
public class MangoCake implements Cake {
    @Override
    public void cakeColor() {
        System.out.println("The cake's color is yellow.");
    }

    @Override
    public void cakeStyle() {
        System.out.println("The cake's style is square.");
    }
}
```

好了，具体的蛋糕该是什么样，我们都规划好了，下面是时候生产蛋糕了

要生产蛋糕，就需要工厂或者说作坊，那么为了规范我们的工厂该做什么，我们先定义一个抽象的工厂类，这里我们还是采用反射的方式，当然，如果你不喜欢用反射，那么你也可以定义普通的抽象方法，这些都是可以根据实际情况来决定的，没有硬性规定
```java
public abstract class Factory {
    public abstract <T extends Cake> T createProduct(Class<T> clz);
}
```

实现具体的工厂操作，让我们的工厂能够生产我们要的蛋糕
```java
public class CakeFactory extends Factory {
    @Override
    public <T extends Cake> T createProduct(Class<T> clz) {
        Cake cake = null;
        try {
            cake = (Cake) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) cake;
    }
}
```

OK，蛋糕已经规划好了，工厂也造好了，万事俱备只欠东风，我们来测试一下(做蛋糕)~
```java
 public static void main(String[] args) {
        /*创建蛋糕工厂*/
        Factory factory = new CakeFactory();
        /*制作草莓蛋糕*/
        StrawberryCake strawberryCake = factory.createProduct(StrawberryCake.class);
        /*草莓蛋糕的颜色*/
        strawberryCake.cakeColor();
        /*草莓蛋糕的造型*/
        strawberryCake.cakeStyle();

        /*制作芒果蛋糕*/
        MangoCake mangoCake = factory.createProduct(MangoCake.class);
        /*草莓芒果的颜色*/
        mangoCake.cakeColor();
        /*草莓芒果的造型*/
        mangoCake.cakeStyle();
    }
```

Result：
```console
The Strawberry Cake's color is red.
The Strawberry Cake's style is heart-snaped.
The Mango Cake's color is yellow.
The Mango Cake's style is square.
```

大功告成~

END.