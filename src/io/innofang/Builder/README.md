# Builder（建造者模式）

> 对一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示

其实建造者模式在项目中进场能够看到，比如在Android中我们使用AlertDialog的时候

```java
    AlertDialog.Builder builder =
          new AlertDialog.Builder(context)
                         .setIcon(R.mipmap.ic_launcher)
                         .setTitle("This is title")
                         .setMessage("This is Message")
                         .setPositiveButton("ok", null)
                         .create();
    builder.show();

```

类似的还有很多的库都使用了这种建造者模式，可以见的学习这种模式的必要性了

## Builder（建造者模式）的UML类图

<img src="http://img.my.csdn.net/uploads/201204/02/1333347984_5022.jpg" />

其中：

 + Builder类 : 是抽象类，用来规范子类的组建
 + Concrete Builder类 : 是Builder的具体实现类
 + Director类 : 用于将产品同一组装

## 下面来看一下例子，如何实现一个简单的Builder

以构建一辆车为例，一辆车大体上是有车牌，颜色，车的标牌等构成

首先创建构建着接口
```java
public interface Builder {

    // 构建车的颜色
    void buildColor(String color);

    // 构建车的车牌
    void buildLicensePlate(String licensePlate);

    // 构建车的商标
    void buildBrand(String brand);

    // 构建完成最终的汽车
    Car build();
}
```

然后创建汽车产品类

```java
public class Car {

    private String color;
    private String licensePlate;
    private String brand;

    public void setColor(String color) {
        this.color = color;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
```

然后创建汽车构建实现类

```java
public class CarBuilder implements Builder {

    Car car;

    public CarBuilder() {
        this.car = new Car();
    }

    @Override
    public void buildColor(String color) {
        car.setColor(color);
    }

    @Override
    public void buildLicensePlate(String licensePlate) {
        car.setLicensePlate(licensePlate);
    }

    @Override
    public void buildBrand(String brand) {
        car.setBrand(brand);
    }

    @Override
    public Car build() {
        return car;
    }
}

```

最后创建产品组装类
```java
public class Director {

    Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(String color, String licensePlate, String brand) {
        builder.buildColor(color);
        builder.buildLicensePlate(licensePlate);
        builder.buildBrand(brand);
    }
}
```

一个简单的Builder构建者就完成了，我们来测试一下
```java
Builder builder = new CarBuilder();
Director director =new Director(builder);
director.construct("red", "A88888", "Ferrari");
System.out.println(builder.build().toString());
```

Result:<br>
`Car{color='red', licensePlate='A88888', brand='Ferrari'}`

一俩车牌号为A88888的红色法拉利就做完了！

但是为什么不是链式调用呢？


如果需要链式调用的话就需要对代码做一下修改
比如这里要创建一辆Ferrari
我们先创建一个Ferrari类，并且创建一个Builder内部类
具体代码如下：
```java
public class Ferrari {

    private String color;
    private String licensePlate;
    private String brand;

    public void setColor(String color) {
        this.color = color;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public static class Builder{

        Ferrari ferrari;

        public Builder(){
            ferrari = new Ferrari();
        }

        public Builder setColor(String color){
            ferrari.setColor(color);
            return this;
        }

        public Builder setLicensePlate(String licensePlate) {
            ferrari.setLicensePlate(licensePlate);
            return this;
        }

        public Builder setBrand(String brand){
            ferrari.setBrand(brand);
            return this;
        }

        public Ferrari build(){
            return ferrari;
        }

    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

}

```

测试一下
```java
 // Call Chaining
Ferrari ferrari = new Ferrari.Builder()
        .setBrand("Ferrari")
        .setColor("Red")
        .setLicensePlate("B88888")
        .build();
System.out.println(ferrari.toString());
```

Result:<br>
`Car{color='Red', licensePlate='B88888', brand='Ferrari'}`

- - -

## 总结

关于构建者模式：

**优点** 具有良好的封装性，容易扩展<br>
**缺点** 会产生多余的Builder对象，消耗内存







