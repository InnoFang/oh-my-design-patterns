# Proxy（代理）

代理模式一种十分常用的模式。日常生活中，我们也经常使用代理，比如有时候你会叫你的朋友代取快递等

总之，代理模式就是将一些自己不想或无法处理的事，交给代理者去做。

## Proxy（代理）的UML类图
![](https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/proxy.png)

 + Subject : 代理者和被代理者的共同主题
 + ProxySubject : 代理类
 + RealSubject  : 被代理类或者叫真实类
 + Client : 代理类使用者

 之所以需要代理类和被代理类都实现统一的接口，是为了保证客户类的透明性，在使用代理类时可以执行被代理类的操作

## 代理模式的简单实现

刚才例举了叫朋友带去快递的例子，那么现在就以这个案例为原型，来实现以下代理模式

为了更好的体现代理模式的优势，这里将整个取快递的流程分为：

 1. 接收快递短信通知
 2. 取快递
 3. 签字验收三个步骤

那么首先实现抽象主题类

IPicker
```java
public interface IPicker {
    /*接收快递短信通知*/
    void receiveMessage();
    /*取快递*/
    void takeCourier();
    /*签字验收三个步骤*/
    void signatureAcceptance();
}
```

具体的取快递的人
```java
public class RealPicker implements IPicker {
    @Override
    public void receiveMessage() {
        System.out.println("Receive text message");
    }

    @Override
    public void takeCourier() {
        System.out.println("Take the courier");
    }

    @Override
    public void signatureAcceptance() {
        System.out.println("Signature Acceptance");
    }
}
```

代理去快递的人
```java
public class ProxyPicker implements IPicker {

    private IPicker picker;

    public ProxyPicker(IPicker picker) {
        this.picker = picker;
    }

    @Override
    public void receiveMessage() {
        picker.receiveMessage();
    }

    @Override
    public void takeCourier() {
        picker.takeCourier();
    }

    @Override
    public void signatureAcceptance() {
        picker.signatureAcceptance();
    }
}
```

OK, 下面就可以叫自己的代理者去取快递了
```java
IPicker picker = new RealPicker();
ProxyPicker proxyPicker = new ProxyPicker(picker);

proxyPicker.receiveMessage();
proxyPicker.takeCourier();
proxyPicker.signatureAcceptance();
```

执行结果如下:
```console
Receive text message
Take the courier
Signature Acceptance
```

上面介绍了 `静态代理` 的实现，那么下面来介绍一下 `动态代理`

首先先明白一点为什么要使用 `动态代理` ？

如果只是代理一个类似乎并没有什么问题，但是如果有很多类怎么办？为每一个类都创建一个代理类吗？
如果是那样的话，那么类的数量可能会成爆炸式增长，而且，如果有一个真是类新增了多个方法，那么对应的代理类也要修改，那么这就很有可能出错

那么如何解决这个问题呢？

答案就是使用 `动态代理` 。动态代理需要借助Java的动态代理机制，其原理就是Java的反射机制

为了实现动态代理，这里需要两个类
 + `java.lang.reflect.InvocationHandler` 这是一个接口，代理类需要实现这个接口
 ```java
 public interface InvocationHandler {

     public Object invoke(Object proxy, Method method, Object[] args)
         throws Throwable;
 }
 ```
   这个接口内部的 `invoke` 方法，这个方法就是用来调用具体的被代理方法的

 + `java.lang.reflect.Proxy` 这个类内部有一个静态方法
 ```java
 public static Object newProxyInstance(ClassLoader loader,
                                           Class<?>[] interfaces,
                                           InvocationHandler h)
         throws IllegalArgumentException{
          ...
          // 省略具体实现
 }
 ```
    使用这个静态方法来为一组接口动态的生成代理类对象，它含有三个参数：
    - `ClassLoader loader` : 用于加载动态代理
    - `Class<?>[] interfaces` : 接口数组
    - `InvocationHandler h` : 动态代理实现类

讲了那么多，那么来具体实现这个动态代理

首先是实现`InvocationHandler` 接口
```java
public class DynamicProxy implements InvocationHandler {

    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(object, args);
    }
}
```
可以看到，在`invoke`方法的内部，还调用了 method 对象的 invoke 方法

下面就来试用一下动态代理
```java
IPicker iPicker = new RealPicker();
DynamicProxy proxy = new DynamicProxy(iPicker);
ClassLoader loader = iPicker.getClass().getClassLoader();
IPicker dynamicPicker = (IPicker) Proxy.newProxyInstance(
     loader, new Class[]{IPicker.class}, proxy);

dynamicPicker.receiveMessage();
dynamicPicker.takeCourier();
dynamicPicker.signatureAcceptance();
```

执行结果如下
```console
Receive text message
Take the courier
Signature Acceptance
```
结果跟之前的一样


END.