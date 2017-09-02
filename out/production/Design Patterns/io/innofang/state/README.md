# State（状态模式）

什么是状态模式呢？

有时候做一件事会存在很多的状态，而在不同的状态之下会有不同的行为。而状态模式就是根据不同的状态来改变不同的行为

下面看一下状态模式的UML类图

# State（状态模式）的UML类图

![](https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/state.png)

 + Context：上下文，维护状态的实例
 + State：抽象状态类，用于表示一系列状态下的行为有哪些
 + ConcreteState：具体的状态类，不同的状态都有自己的一套实现

如果你看过之前的策略模式的话，你会发现这两个模式的类图其实是一模一样的

但即使在UML类图上这两个模式一样，这两个模式的目的和本质都是不一样的

 + 策略模式中，你可以根据不同的情况动态改变现在的策略
 + 状态模式中，每一种状态的情况都是不可替换的

概念较抽象，还是上代码吧~

# 状态模式的简单实现

在日常生活中，做每一件事都有一系列的状态，就拿打游戏来举例吧

现在有一个玩家，他打算玩一款打怪升级的游戏，那么在玩游戏的过程中，他会有一系列的状态：打怪时的状态，升级时的状态等等

 现在先抽象一个游戏状态的类，它具有以下行为：

 + 打怪
 + 获得经验
 + 进入下一关
 + 捡拾物品

那么根据玩游戏的状态划分，可以粗略的划分为：

 + 游戏开始状态
 + 游戏结束状态

那么不同的状态，它的行为肯定是不一样的，如果在以往的代码编写中，肯定会使用if-else或者switch-case来解决这种简单的问题

但是随着产品的迭代，这样程序的扩展性和鲁棒性都将变差，所以对于这种不同情况有不同行为实现的情况下，选择状态模式是一种不错选择

首先，需要先将状态抽象出来形成一个接口
```java
public interface GameState {
    /*打怪*/
    public void killMonster();
    /*获得经验*/
    public void gainExperience();
    /*进入下一关*/
    public void next();
    /*捡拾物品*/
    public void pick();
}
```

那么接下来就可以根据不同的状态开始展开不同的行为实现了：

游戏开始状态
```java
public class GameStartState implements GameState {
    /*击杀一只怪物*/
    @Override
    public void killMonster() {
        System.out.println("Kill a Monster");
    }

    /*获得5经验值*/
    @Override
    public void gainExperience() {
        System.out.println("Gain 5 EXP");
    }

    /*进入下一关*/
    @Override
    public void next() {
        System.out.println("Good! please enter next level");
    }

    /*捡到一件好东西*/
    @Override
    public void pick() {
        System.out.println("Wow! You pick a good thing");
    }
}
```

游戏结束状态
```java
public class GameOverState implements GameState {
    /*游戏没开始，无法打怪*/
    @Override
    public void killMonster() {
        System.out.println("Please start game first");
    }
    /*游戏没开始，无法获得经验*/
    @Override
    public void gainExperience() {

    }
    /*游戏已经结束，下一步就是选择是否重新开始*/
    @Override
    public void next() {
        System.out.println("You want to challenge again?");
    }
    /*游戏没开始，无好东西可以捡*/
    @Override
    public void pick() {
        System.out.println("Please start game first");
    }
}
```

什么状态下该干什么都已经想好了，下一步就是来一个玩家开始游戏了
```java
public class Player {
    /*游戏状态*/
    GameState state;
    /*游戏状态的设置*/
    public void setState(GameState state) {
        this.state = state;
    }
    /*游戏开始*/
    public void gameStart() {
        setState(new GameStartState());
        System.out.println("\n-----Game Start, ready to fight-----\n");
    }
    /*游戏结束*/
    public void gameOver(){
        setState(new GameOverState());
        System.out.println("\n-----         Game Over        -----\n");
    }
    /*打怪*/
    public void killMonster(){
        state.killMonster();
    }
    /*获得经验*/
    public void gainExperience() {
        state.gainExperience();
    }
    /*下一关*/
    public void next(){
        state.next();
    }
    /*捡东西*/
    public void pick(){
        state.pick();
    }

    public static void main(String[] args) {
        /*游戏开始后的一系列操作和结束后的操作*/
        Player player = new Player();
        player.gameStart();
        player.killMonster();
        player.gainExperience();
        player.next();
        player.pick();
        player.gameOver();
        player.next();
        player.killMonster();
        player.pick();
    }
}
```

代码内都有注释，思路还是比较清晰的，可以看到，玩家代码中没有对游戏状态的逻辑判断，使得代码看起来更加的简洁

看看玩家玩的怎么样吧~

```console

-----Game Start, ready to fight-----

Kill a Monster
Gain 5 EXP
Good! please enter next level
Wow! You pick a good thing

-----         Game Over        -----

You want to challenge again?
Please start game first
Please start game first

```

根据输出结果对比可以看到，在游戏开始和结束后，玩家执行相同的操作都会有不同的实现结果

## 总结

来总结一下状态模式的优缺点吧

 + 优点：状态模式提供了一个更好的方法来组织与特定状态的相关代码，将繁琐的状态判断转换成结构清晰的状态类族，在避免代码膨胀时的同时也保证了可扩展性与可维护性
 + 缺点：类和对象的个数会对应的增加

END.