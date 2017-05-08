# Template Method（模板方法）

在日常的开发中，模板方法是一种用于流程封装的设计模式

比如，类似的功能或许具体的实现细节不一样，但是功能的执行流程是一样的，这时通过将执行流程封装起来，那么在使用这种模式的时候，只需要去关注如何实现功能细节就可以了。这样将公共代码提取出来，便于维护。

# Template Method（模板方法）的UML类图
![](https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/template_method.png)

 + AbstractClass : 抽象模板，定义了模板方法的执行流程
 + ConcreteClass : 具体实现类


# 模板方法的简单实现

如果非要说一个现实中的案例的话，我觉可以例举工厂中的流水线 (Assembly Line)

因为一条流水线的分工是明确的，流水线的头部是加工元器件，中部是元器件装配，尾部就是将电子产品打包装箱，这是流水线作业的流程，但是具体是装配什么电子产品，需要在那个流程上注意什么细节，每一条流水线都是不一样的，如果开发者需要开发类似的功能，利用模板方法模式是再合适不过的了

经过上面的介绍，下面就来实现以下这个案例

首先就是对流水线作业流程进行抽象
```java
public abstract class AssemblyLine {
    /* 生产产品外壳 */
    protected void onProduceShell() {
        System.out.println("Produce Shell");
    }
    /* 生产元器件 */
    protected void onProduceComponents() {
        System.out.println("Produce some components");
    }
    /* 元器件装配 */
    protected void onAssemblyComponents() {
        System.out.println("Assembly Components");
    }
    /* 产品测试 */
    protected void onTestProducts(){
        System.out.println("Test Products");
    }
    /* 产品装箱 */
    protected void onProductPacking() {
        System.out.println("Product Packing");
    }
    /* 流水线产品制作流程封装 */
    public final void product() {
        System.out.println("+------Start Product------+");
        onProduceShell();
        onProduceComponents();
        onAssemblyComponents();
        onTestProducts();
        onProduceComponents();
        onProductPacking();
        System.out.println("+------Finish Product------+");
    }
}
```

在流水线作业中，我将具体流程分成了上面五个部分：

 + 生产产品外壳
 + 生产元器件
 + 元器件装配
 + 产品测试
 + 产品装箱

并且对于流水线的执行流程的代码使用了 final 修饰，这样子类就不可以重写这个方法

为了简单起见，内部方法的实现用一句输出代替，但是具体实现细节应该根据具体情况而定，因为这种流程式的功能设计，或多说少都会有共有的实现，那么就可以将共有代码写在抽象类的对应方法内部

如果这是一家电子产品生产厂的流水线，那么就会各种各样的电子产品，那么这里例举生产收音机的流水线和生产电脑的流水线，其他情况可以自行拓展

生产收音机的流水线
```java
public class RadioAssemblyLine extends AssemblyLine {
    /* 生产收音机元器件和天线 */
    @Override
    protected void onProduceComponents() {
        System.out.println("Product Radio Components and Antennas");
    }
}
```
在这里，只重写了一个生产元器件的方法

再来看一下生产电脑的流水线，为了区分与生产收音机的流水线，这里多重写几个方法
```java
public class ComputerAssemblyLine extends AssemblyLine {
    /* 生产铝合金外壳和液晶显示屏 */
    @Override
    protected void onProduceShell() {
        System.out.println("Product Aluminum housing and Liquid Crystal Display");
    }
    /* 生产元器件和键盘 */
    @Override
    protected void onProduceComponents() {
        System.out.println("Product Components and keyboard");
    }
    /* 将产品打包并标上苹果标签 */
    @Override
    protected void onProductPacking() {
        System.out.println("Pack and Mark the Apple trademark");
    }
}
```
这里多重写了产品装配方法和产品打包方法

可以看到的是，在这两个具体的流水线中，都只写了区别于其他流水线的代码，代码更加的简洁了

因为，流水线的工作流程都已经封装好了，那么在接下来的测试中，只需要直接调用就可以了
```java
AssemblyLine assemblyLine = new RadioAssemblyLine();
assemblyLine.product();

System.out.println();

assemblyLine = new ComputerAssemblyLine();
assemblyLine.product();
```

看一下输出结果
```console
+------Start Product------+
Produce Shell
Product Radio Components and Antennas
Assembly Components
Test Products
Product Radio Components and Antennas
Product Packing
+------Finish Product------+

+------Start Product------+
Product Aluminum housing and Liquid Crystal Display
Product Components and keyboard
Assembly Components
Test Products
Product Components and keyboard
Pack and Mark the Apple trademark
+------Finish Product------+
```

# 总结

在上面的编码过程中，模板方法最明显的优势就是将不变的地方进行封装，扩展可变的部分，这样操作更有利于维护。

模板方法是一种十分常用的设计模式，如果你是一名 Android Developer ，那么你应该知道 AsyncTask 这个用于异步加载的工具，那么 AsyncTask 就是一个在 Android 中一个模板方法的使用案例，当然不只有 AsyncTask，Android 的生命周期函数也使用了模板方法这个设计模式，有兴趣的同学可以去查看一下源码。

END.