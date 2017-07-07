# Adapter Class/Object（适配器）

在平常开发当中，适配器 ( Adapter ) 是十分常用的模式，比如常用的 RecyclerView 的 Adapter，ListView 的 Adapter 等。但是在经常使用，但是并不知道适配器模式的具体实现原理是什么？那么下面就将结合具体案例分析一下这个适配器模式。

首先先理解什么是适配器？平常在手机充电或者给笔记本电脑充电时，都会使用到充电器。因为我们知道插板上的电压是 220 V ，如果直接连接上设备，则会将给烧坏，那么适配器的作用就是这样 ———— **将原本因接口不匹配而无法在一起工作的两样东西能够在一起工作**

## Adapter Class/Object（适配器）的 UML 类图

这里要说明的是，适配器按类型来分有两种：
 + 类适配器
 + 对象适配器

下面是对应的 UML 类图

> 类适配器

![](https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/class_adapter.png)

 + Target : 适配器接口
 + Adaptee : 需要适配的角色
 + Adapter : 适配器，将需要适配的角色的对应操作进行适配

![](https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/object_adapter.png)

 这里的三个角色同上，但是这里使用了组合的方式

那么这里这两种实现方式有什么不同的呢？
 + 相同点：都是将被适配的类的 API 转换成目标类的 API
 + 不同点：
   - 类适配器使用**继承**的方式连接到 Adaptee 类
   - 对象适配器使用**组合**的方式连接到 Adaptee 类

使用组合的方式实现接口兼容的效果更为灵活，好处就是被适配对象中的方法不会暴露出来，而类适配器由于继承了被适配对象，因此也能使用被适配对象中的方法

相比之下，**使用对象适配器模式更加灵活、使用**

## 适配器模式的简单实现

为了对两种方式进行比较，下面会分别实现这两中方式，以给移动设备充电为例，将 220 V 电压转换成 5 V 电压

### 类适配器模式的简单实现

首先就是提供目标接口，表示我们期望进行怎样的适配，这里期望将电压适配成 5 V
```java
public interface VoltFive {

    int provideVoltFive();

}
```

接下来就是实现被适配类，这里被适配对象为 220 V 电压
```java
public class Volt220 {

    public int provideVolt220() {
        return 220;
    }

}
```

然后就可根据类适配器的实现方式实现具体的适配器了，继承 220 V 被适配对象，并实现将电压转换成 5 V 的接口
```java
public class VoltAdapter extends Volt220 implements VoltFive{

    @Override
    public int provideVoltFive() {
        return 5;
    }
}
```

测试
```java
VoltAdapter adapter = new VoltAdapter();
int volt = adapter.provideVoltFive();
System.out.println("After adapted, the volt is :" + volt);
```

测试结果
```console
After adapted, the volt is :5
```

同时根据上面的分析可以知道，因为继承了被适配对象，所以这里的适配还可以输出 220 V 电压，具体操作可以自己尝试


### 对象适配器模式的简单实现

因为目标接口和被适配对象与上面相同，所以这里不再贴出，具体的可以参考上面。下面来看一下对象适配器模式的具体实现
```java
public class VoltAdapter implements VoltFive {

    private Volt220 volt220;

    public VoltAdapter(Volt220 volt220) {
        this.volt220 = volt220;
    }

    @Override
    public int provideVoltFive() {
        int volt = volt220.provideVolt220();
        /* convert the 220V to 5V */
        volt = 5;
        return volt;
    }

    public int provideVolt220(){
        return volt220.provideVolt220();
    }

}
```

因为使用了组合的方式，所以这里需要给构造函数传入一个被适配对象实例，而具体如何实现转换方式，就需要在 `provideVoltFive()` 中进行操作，因为这次的示例比较简单，所以这里的操作仅供参考

测试
```java
Volt220 volt220 = new Volt220();
VoltAdapter adapter = new VoltAdapter(volt220);
int volt = adapter.provideVoltFive();
System.out.println("After adapted, the volt is :" + volt);
```

测试结果同上

## 总结

- 优点
  - 复用性：通过使用适配器让不符合系统需求的接口得到更好的复用
  - 扩展性：通过使用适配器模式，可以在原有的功能上扩展自己实现的功能
- 缺点
  - 过多的使用适配器模式，会使系统变得凌乱，不易整体把握。若非必要可以直接对功能进行重构

END.

