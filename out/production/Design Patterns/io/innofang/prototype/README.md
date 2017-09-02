# Prototype（原型）

原型模式，是利用已有的实例对象通过克隆的方式，复制出一个具有相同属性的对象，起作用在于
当在面临创建一个复杂对象或实例时，通过克隆可以是程序更高效的运行，保证了程序的效率，因此
原型模式也是一种创建型模式

# Prototype（原型）的UML类图

![](https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/prototype.png)

 + Clone：抽象类或者接口，声明具备克隆的能力
 + ConcretePrototype：具体的原型类


# 原型模式的使用场景

 + 类初始化需要消耗非常多的资源，这个资源包括数据，硬件资源等，通过原型拷贝避免这些小号
 + 通过new产生一个对象需要非常繁琐的数据准备或访问权限，这时可以使用原型模式
 + 一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，可以考虑使用原型模式拷贝多个对象供调用者使用，即保护性拷贝

关于原型模式，有一个需要注意的地方，即 浅拷贝 和 深拷贝

那么这两个什么区别呢？这里暂且不提，当我们通过一个简单例子介绍了原型模式过后，再来介绍

# 原型模式的简单实现

首先，在Java中，我们是使用Cloneable接口作为Prototype

那么，对于具体的原型类，只需要实现该接口即可，这里我们写一个WordDocument类，用来作为具体的原型实现
，因为对于文档的复制，我们在平常的工作中再熟悉不过了

```java
public class WordDocument implements Cloneable {

    private String text;
    private ArrayList<String> images = new ArrayList<>();

    public WordDocument() {
        System.out.println("-------------init-------------");
    }


    public String getText() {
        return text;
    }

    public void setText(String mText) {
        this.text = mText;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> mImages) {
        this.images = mImages;
    }

    public void addImage(String image) {
        images.add(image);
    }

    public void showDocument() {
        System.out.println("-------------Start-------------");
        System.out.println("Text : " + text);
        System.out.println("Image List : ");
        for (String mImage : images) {
            System.out.println("Image Name : " + mImage);
        }
        System.out.println("------------- End -------------");
    }

    protected WordDocument clone() {
        try {
            WordDocument doc = (WordDocument) super.clone();
            doc.text = this.text;
            doc.images = this.images;
            return doc;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
```

解释一下上面的代码

 + 首先这个word文档有一段文本和若干图片，图片的描述用List来保存，
 + 接着为这些内容实现getter方法和setter方法，并且实现一个showDocument方法用来展示文档内容
最后，
 + 最至关重要的，是实现了Cloneable的clone方法，在这个方法中可以很清晰的看到，当调用这方法时，会调用父类
 的clone()方法来完成WordDocument文档的实例复制，然后将当前WordDocument的内容复制给了clone产生的实例，
 最终完成了WordDocument的复制。


那么，父类的clone方法是什么呢？

首先我们得知道，每一个java类的祖先类都是Object类，所以这个就是调用
的Object的clone方法，但是我们通过源码可以看到Object的clone方法其实是一个本地方法
 ```java
 public class Object {
    // ...
    protected native Object clone() throws CloneNotSupportedException;
    // ...
 }
 ```


好，完成了具体的原型类的实现，我们来测试一下

```java
public class Client {

    public static void main(String[] args) {

        WordDocument originDoc = new WordDocument();
        originDoc.setText("This is a document");
        originDoc.addImage("Image 1");
        originDoc.addImage("Image 2");
        originDoc.addImage("Image 3");
        originDoc.showDocument();

        WordDocument copyDoc = originDoc.clone();
        copyDoc.showDocument();

        copyDoc.setText("This is a copy document");
        copyDoc.showDocument();

        originDoc.showDocument();

    }
}

```

在测试类中，我们通过clone复制了一个实例，并且这里尝试通过修改 copyDocument 的内容，并显示其内容

输出结果
```console
-------------init-------------
-------------Start-------------
Text : This is a document
Image List :
Image Name : Image 1
Image Name : Image 2
Image Name : Image 3
------------- End -------------
-------------Start-------------
Text : This is a document
Image List :
Image Name : Image 1
Image Name : Image 2
Image Name : Image 3
------------- End -------------
-------------Start-------------
Text : This is a copy document
Image List :
Image Name : Image 1
Image Name : Image 2
Image Name : Image 3
------------- End -------------
-------------Start-------------
Text : This is a document
Image List :
Image Name : Image 1
Image Name : Image 2
Image Name : Image 3
------------- End -------------
```

根据输出结果，可以发现，当我们克隆产生的对象修改时，其原型不会改变

但，真的是这样吗？

我们再来测试一下，我们给 copyDocument 添加图片信息

仍然是Client类的main函数中
```java
 ...
WordDocument copyDoc = originDoc.clone();
copyDoc.showDocument();

copyDoc.setText("This is a copy document");

// add this line to test the origin document what will happen when the copy document add a image
copyDoc.addImage("a new Image");

copyDoc.showDocument();

originDoc.showDocument();
```


输出结果：

```console
...
-------------Start-------------
Text : This is a document
Image List :
Image Name : Image 1
Image Name : Image 2
Image Name : Image 3
------------- End -------------
-------------Start-------------
Text : This is a copy document
Image List :
Image Name : Image 1
Image Name : Image 2
Image Name : Image 3
Image Name : a new Image
------------- End -------------
-------------Start-------------
Text : This is a document
Image List :
Image Name : Image 1
Image Name : Image 2
Image Name : Image 3
Image Name : a new Image
------------- End -------------
```

这时，我们发现，当我们修改了copyDocument类的内容时，originDocument的内容也跟着改变了

那这是为什么呢？

前面我们提到过，浅拷贝 和 深拷贝

那么，先将结论扔出来，之所以会在只修改copyDocument的情况下，originDocument的内容也会改变的原因是，
在这里我们使用的是 浅拷贝

那么什么是浅拷贝，又为什么会出现上面的情况呢？

我们在利用originDocument的clone方法进行拷贝时，在clone方法内部，
可以发现 copy 的 images 的实例只是简单的指向了当前对象(即originDocument的images)，
并没有重新构造一个images对象，这时，如果我们修改copyDocument的images时，就是导致originDocument的images的内容
也跟着改变，这就是所谓的浅拷贝

那么，如何解决这个问题呢？

答案是，利用深拷贝，那么怎么利用深拷贝呢？

很简单，只需要将 images 也用clone的方式拷贝过来就好了，

修改WordDocument的clone方法
```java
...
protected WordDocument clone() {
        try {
            WordDocument copy = (WordDocument) super.clone();
            copy.text = this.text;
            // copy.images = this.images;
            copy.images = (ArrayList<String>) this.images.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

```

在上面代码中，利用ArrayList的clone方法来完成我们images的clone

然后我们再来测试一下，Client的代码不变，运行程序显示结果如下

```console
-------------init-------------
-------------Start-------------
Text : This is a document
Image List :
Image Name : Image 1
Image Name : Image 2
Image Name : Image 3
------------- End -------------
-------------Start-------------
Text : This is a document
Image List :
Image Name : Image 1
Image Name : Image 2
Image Name : Image 3
------------- End -------------
-------------Start-------------
Text : This is a copy document
Image List :
Image Name : Image 1
Image Name : Image 2
Image Name : Image 3
Image Name : a new Image
------------- End -------------
-------------Start-------------
Text : This is a document
Image List :
Image Name : Image 1
Image Name : Image 2
Image Name : Image 3
------------- End -------------
```

问题解决了！

那么在拷贝对象时，对于引用型的字段也要采用拷贝的形式，而不是单纯引用的形式，即深拷贝

那么在日常开发中，为了减少错误，在使用原型模式时，建议使用深拷贝

## 原型模式的优缺点：

 + 优点：原型模式是内存中二进制流的拷贝，要比直接new一个对象性能好很多，特别是要在一个循环体内产生大量的对象时，原型模式可以更好地体现其优点

 + 缺点：由于原型模式是在内存中拷贝，构造函数是不会执行的，在实际开发当中应该注意这个潜在问题

END.