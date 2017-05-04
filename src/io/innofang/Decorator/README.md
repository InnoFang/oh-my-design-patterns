# Decorator（装饰）

装饰模式 ( Decorator Pattern )，或者说叫包装模式 ( Wrapper Pattern )，作为结构型模式，其主要功能通俗的说就是在原有对象的基础上添加新的东西

装饰模式在平常生活中也是很常见的，这里就以蛋糕店做蛋糕为例吧

>当我们经过一系列手工操作制作出一个基本的蛋糕胚时，蛋糕店想要将这个蛋糕卖出去，那么就需要在这个蛋糕胚上做一些装饰，比如涂上一层奶油，加一些巧克力或者水果之类的。

这样想来装饰模式也是很好理解的。当我们需要透明且动态地扩展类的功能时，我们就可以使用装饰模式

# Decorator（装饰）模式的 UML 类图

![](https://github.com/InnoFang/DesignPatterns/blob/master/uml/decorator.png)

 + Component : 组件接口，被装饰的原始对象
 + ConcreteComponent : 具体组件，组件接口的实现类，被装饰的具体对象
 + Decorator : 抽象装饰器，内部持有组件对象的一个实例
 + ConcreteDecorator : 具体装饰器
 + Client : 客户类

下面看一下装饰器模式的简单实现

首先就是 Component 组件接口
```java
public interface Component {

    void operation();

}
```

然后就是具体的组件，需要被装饰的对象 ConcreteComponent
```java
public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("This is Concrete Component");
    }
}
```
