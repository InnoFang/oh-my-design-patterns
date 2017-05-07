# Factory Method（工厂方法）

工厂，顾名思义是用来生产东西的，那么在平常Coding的过程中，能用在什么地方呢？

在任何需要生成复杂对象的地方都可以使用工厂模式，当然，如果只是用new就可以创建的对象就没必要使用工厂模式了

## Factory Method（工厂方法）的UML类图

![](https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/factory_method.png)

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

然后，接着定义具体产品类

Concrete Product
```java
public class ConcreteProduct implements Product {
    @Override
    public void method() {
        System.out.println("This is product");
    }
}

```

那么对于具体产品就要有对应的工厂，在此之前先定义一个抽象的工厂类
```java
public abstract class Factory {

    public abstract Product createProduct();
}
```

具体工厂
```java
public class ConcreteFactory extends Factory {

    @Override
    public Product createProduct() {
        return new ConcreteProduct(); // create the product
    }
}
```

OK，我们来测试一下
```java
Factory factory = new ConcreteFactory();
Product product = factory.createProduct();
product.method();
```

Result：
```console
This is product
```

但是，难道我们们每一个产品都要创建一个对应的产品工厂吗？一两个产品还好，但是如果是10个呢？50个呢？这样一来，都会多出很多的类，使得工程更加的冗余

所以在这里，我们完全可以利用反射来减少代码量

为了达成目的，我们首先就需要对抽象工厂做出修改，具体实现如下
```java
public abstract class Factory {

    public abstract <T extends Product> T createProduct(Class<T> clz);

}
```

从上面的代码中可以看出，我们需要让传入一个类，然后经过操作返回一个具体的产品。所以核心就是如何实现这个具体工厂，接着往下看。现在修改具体工厂实现

```java
public class ConcreteFactory extends Factory{

    @Override
    public <T extends Product> T createProduct(Class<T> clz) {
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
Product product = factory.createProduct(ConcreteProduct.class);
product.method();
```

测试结果同上面一样

经过上面的编码，可以发现工厂方法模式大大降低了对象之间的耦合度，这种依赖抽象的架构具有非常好的可扩展性


# 工厂方法模式的简单实现

好，上面只是简单讲解，下面来一个工厂方法的简单实现

这里我们以制作蛋糕为例

现在蛋糕店需要生产两种类型的蛋糕，分别是红色的草莓蛋糕和黄色的芒果蛋糕

因为蛋糕有着不同的制作材料和烘焙时间，所以在制作的过程中就需要区别对待了

那么了解了需求过后我们利用刚学的工厂方法模式来完成需求吧~

首先我们就可以定义一个蛋糕接口
```java
public interface Cake {

    /**
     * 准备蛋糕的材料
     */
    void prepareMaterials();

    /**
     * 烘焙蛋糕
     */
    void baking();

}
```

好，现在该规划我们需要什么材料和烘焙的时间了的，对于草莓蛋糕，根据需求，我们的是草莓奶油并且需要烘焙15分钟

```java
public class Strawberry implements Cake{

    /**
     * 草莓蛋糕需要准备草莓奶油
     */
    @Override
    public void prepareMaterials() {
        System.out.println("prepare Strawberry Cream");
    }

    /**
     * 草莓蛋糕需要烘焙15分钟
     */
    @Override
    public void baking() {
        System.out.println("Baking fifteen minutes");
    }
}
```

那么对于芒果蛋糕呢，我们需要的是芒果奶油的，需要烘焙10分钟
```java
public class MangoCake implements Cake {
   /**
    * 芒果蛋糕需要准备芒果奶油
    */
   @Override
   public void prepareMaterials() {
       System.out.println("prepare Mango Cream");
   }

   /**
    * 芒果蛋糕需要烘焙10分钟
    */
   @Override
   public void baking() {
       System.out.println("Baking ten minutes");
   }
}
```

好了，具体的蛋糕制作流程都规划好了，下面是时候生产蛋糕了

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
        strawberryCake.prepareMaterials();
        strawberryCake.baking();

        System.out.println();

        /*制作芒果蛋糕*/
        MangoCake mangoCake = factory.createProduct(MangoCake.class);
        mangoCake.prepareMaterials();
        mangoCake.baking();
}
```

Result：
```console
prepare Strawberry Cream
Baking fifteen minutes

prepare Mango Cream
Baking ten minutes
```

大功告成~

END.