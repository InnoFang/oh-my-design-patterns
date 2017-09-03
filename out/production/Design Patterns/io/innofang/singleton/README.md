# Singleton (单例模式)

> 确保一个类有且只有一个实例，避免产生多个对象消耗过多的资源，或者某种类型的对象只应该有且只有一个

## 实现单例模式的几个注意点：

 1. 构造函数不对外开放，将其设为 private
 2. 通过一个静态方法或者枚举返回一个单例类对象
 3. 确保单例类的对象有且只有一个，尤其是在多线程环境下
 4. 确保单例类对象在反序列化时不会重新构建对象

## 实现方式汇总

### 饿汉式

 ```java
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }
}
```

### 懒汉式

```java
public class NotThreadSafeSingleton {

    private static NotThreadSafeSingleton instance;

    private NotThreadSafeSingleton() {}

    public static NotThreadSafeSingleton getInstance() {
        if (null == instance) {
            instance = new NotThreadSafeSingleton();
        }
        return instance;
    }
}
```
**优点：** 只有在使用时才会实例化，在一定程度上节约资源

**缺点：** 第一次加载时需要及时进行实例化，反应稍慢，线程不安全

有的时候为了线程同步也会为 `getInstance()` 添加 `synchronized` 关键字

```java
public class ThreadSafeSynchronizedSingleton {

    private static ThreadSafeSynchronizedSingleton instance;

    private ThreadSafeSynchronizedSingleton() {}

    public static synchronized ThreadSafeSynchronizedSingleton getInstance() {
        if (null == instance) {
            instance = new ThreadSafeSynchronizedSingleton();
        }
        return instance;
    }
}
```
**优点：** 在多线程的情况下保证单例对象唯一性的手段

**缺点：** 每次调用 `getInstance()` 方法都进行同步，造成不必要的开销

### Double Check Lock (DCL) 实现单例
```java
public class ThreadSafeDoubleCheckSingleton {

    private static volatile ThreadSafeDoubleCheckSingleton instance;

    private ThreadSafeDoubleCheckSingleton() {}

    public static ThreadSafeDoubleCheckSingleton getInstance() {
        if (null == instance) {
            synchronized (ThreadSafeDoubleCheckSingleton.class) {
                if (null == instance) {
                    instance = new ThreadSafeDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
```
**优点：** 既能够在需要时才初始化单例，又能够保证线程安全，且单例对象初始化后调用 `getInstance()` 不进行同步锁，资源利用率高

**缺点：** 第一次加载时反应稍慢，也由于 Java 内存模型的原因偶尔会失败，在高并发情况下可能出现 DCL 失效问题，虽然概率很小

**总结：** 能够在绝大多数场景下保证单例对象的唯一性，除非你的代码在并发场景比较复杂，或低于 JDK 6 版本下使用，否则，这种方式一般能够满足需求

### 静态内部类单例模式

```java
public class ThreadSafeStaticInnerClassSingleton {

    private ThreadSafeStaticInnerClassSingleton() {}

    private static class Holder {
        private static ThreadSafeStaticInnerClassSingleton instance = new ThreadSafeStaticInnerClassSingleton();
    }

    public static ThreadSafeStaticInnerClassSingleton getInstance() {
        return Holder.instance;
    }
}
```

由于在 DCL 在高并发的情况下，可能出现 DCL 失效问题，所以这里**更建议采用这种创建单例类的方式**，原因如下：
当第一次加载 Singleton 类时并不会初始化 `instance`，只有在第一次调用 Singleton 的 `getInstance()` 方法时才会导致 `instance` 初始化，第一次调用时
会导致虚拟机加载 SingletonHolder 类，这种方式技能保证线程安全，也能保证单例对象的唯一性，同时也延迟了单例的实例化。

### 枚举单例

```java
public enum EnumSingleton {
    INSTANCE;
}
```

这种方式写法简单，并且默认枚举实例的创建是线程安全的

### 使用容器实现单例模式

```java
public class SingletonManager {
    private static Map<String, Object> objectMap = new HashMap<>();

    private SingletonManager() {
    }

    public static void registerService(String key, Object instance) {
        if (!objectMap.containsKey(key)) {
            objectMap.put(key, instance);
        }
    }

    public static Object getService(String key) {
        return objectMap.get(key);
    }
}
```

将多种单例类型注入到一个统一的管理类中，在使用时根据 key 获取对象对应类型的对象。

利用这种方式有以下几个优势：

 + 可以管理多种类型的单例
 + 并且在使用可以通过统一的接口进行获取操作，降低用户成本
 + 对用户隐藏了具体实现，降低了耦合度


无论采用哪种方式，都应该根据项目本身来决定。但是这里更建议采用静态内部类的写法，因为该写法不仅保证了线程安全，而且相较于双重锁写法更加优雅。

----------

参考：《Android源码设计模式解析与实战》

[源码地址](https://github.com/InnoFang/DesignPatterns/tree/master/src/io/innofang/singleton)

[更多内容](https://innofang.github.io)
