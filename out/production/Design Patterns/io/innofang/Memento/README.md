# Memento（备忘录模式）

备忘录模式，在日常开发中就是起到一种"备忘"的作用，即在不破坏封闭的前提下，用于保存对象当前状态，并且在之后可以再次恢复到此状态

这种模式很好理解，所以下面直接看UML类图

# Memento（备忘录模式）的UML类图

![Memento](https://raw.githubusercontent.com/innofang/designpatterns/master/uml/memento.png)

 + Originator : 创建备忘录，可用于记录，恢复自身状态
 + Memento : 备忘录实体类，用于存储Originator的内部状态，防止Originator以外的类访问
 + Caretaker : 用于存储和获取备忘录，不能对备忘录的内容进行访问和修改

先来看看 Memoto
```java
public class Memoto {

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
```
Memoto 相当于一个实体类，下面再来看看 Caretaker 类，这个类只负责对 Memoto 的存储与恢复
```java
public class Caretaker {

    private Memoto memoto;

    public void storeMemoto(Memoto memoto) {
        this.memoto = memoto;
    }

    public Memoto restoreMemoto() {
        return memoto;
    }

}
```

而关于备忘录具体要记录的内容是什么，则是有 Originator 来负责
```java
public class Originator {

    private int state;

    public Originator(int state) {
        this.state = state;
    }

    public Memoto createMemoto() {
        Memoto memoto = new Memoto();
        memoto.setState(state);
        return memoto;
    }

    public void restore(Memoto memoto){
        this.state = memoto.getState();
    }

}
```

如果将Originator比作一张记有备忘细节的便签的话，Caretaker就好比是一个便签本，而Memento就相当于你这个备忘录要记录的要点

通俗的说，你在一张便签(Originator)上记录东西，你在记录东西时是按照记录要点(Memento)来记录的，那么便签自然是存在便签本(Caretaker)上的

这三者的关系就是如上所述，下面来看看备忘录模式的简单实现吧

# 备忘录模式的简单实现

既然是备忘录模式，那么要举例的话，还是实现一个备忘录便签本更直观一点

首先是要实现的是备忘录的要点(Memento)，因为只有将细节都规定好了，记录时才能不遗漏
```Memento
public class Memento {
    private String mDate;
    private String mTodo;
    private boolean mIsFinish;

    // 省略 getter 和 setter 方法

    // 省略 toString 方法
}
```
从上面的代码可以看出，在备忘录将要简单的记录日期，要做的事，以及是否完成这些细节

下面就是记录备忘细节，将该类命名为ToDo，即将要做的事
```java
public class ToDo {
    private String mDate;
    private String mTodo;
    private boolean mIsFinish;

    public ToDo() {
        mDate = new SimpleDateFormat("yyyy/MM/dd EE HH:mm:ss").format(new Date());
    }
    // 设置 todo 细节 以及是否完成
    public void setToDoDetail(String todo, boolean isFinish) {
        mTodo = todo;
        mIsFinish = isFinish;
    }
    // 创建备忘录
    public Memento createMemoto() {
        Memento memento = new Memento();
        memento.setDate(mDate);
        memento.setTodo(mTodo);
        memento.setIsFinish(mIsFinish);
        return memento;
    }
    // 从备忘录中恢复数据
    public void restore(Memento memento) {
        mDate = memento.getDate();
        mTodo = memento.getTodo();
        mIsFinish = memento.isFinish();
    }

    // 省略 getter 和 setter 方法

    // 省略 toString 方法
}

```
从上面代码中看出，ToDo的属性是包含memento的属性的，然后在内部完成创建备忘录和恢复备忘录的细节实现

下面就是定义一个备忘录本子，用于存储备忘录
```java
public class Caretaker {

    private Memento mMemoto;

    public void archive(Memento memoto) {
        mMemoto = memoto;
    }

    public Memento getMemoto() {
        return mMemoto;
    }
}
```
正如之前所说，备忘录本子不对备忘录的内容有任何访问和修改，所以这里只需要对备忘录进行存储和获得就可以了

简单实现过后，那么就来测试一下，这里会先创建一份备忘录，然后记录备忘细节，然后再取出一份备忘录，恢复备份细节，然后修改备忘细节
```java
// 创建备忘录
ToDo toDo = new ToDo();
// 下午两点写Java，未完成
toDo.setToDoDetail("Write Java at 2 pm", false);
// 创建备忘录本子，用于存储备忘录
Caretaker caretaker = new Caretaker();
caretaker.archive(toDo.createMemoto());
// 查看备忘细节
System.out.println(toDo.toString());
// 重新拿一份备忘录，并恢复之前的备忘细节，并标注任务已完成
ToDo newToDo = new ToDo();
newToDo.restore(caretaker.getMemoto());
newToDo.setIsFinish(true);
// 查看备忘细节
System.out.println(newToDo.toString());
```

看一下输出结果
```java
ToDo{Date='2017/03/15 星期三 15:18:05', Todo='Write Java at 2 pm', IsFinish=false}
ToDo{Date='2017/03/15 星期三 15:18:05', Todo='Write Java at 2 pm', IsFinish=true}
```

END.
