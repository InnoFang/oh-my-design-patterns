# Facade（外观）模式

外观模式，或者叫门面模式，是一种十分常用的结构性模式。具体体现在我们平常使用的第三方 SDK 上，在使用的过程中，可以发现这些 SDK 具有良好的封装性，我们在调用时是需要调用相关的方法就可以实现我们想要的功能，但是这个方法内部的具体实现我们一概不知，降低了我们的使用成本。简单的一句话总结就是：**外观模式提供了一个高层次的接口，使得子系统更易于使用。**

举一个生活中的例子，在我看来，去餐厅点餐就用到了外观模式。**菜单就像是一个高层次的接口**，将各种菜系和菜品都罗列在一个菜单上，用户根据自己的情况来点菜，但是用户不需要知道这个菜是怎么做吃来的，他只需要在点完菜后等待就可以了，而具体的如何做出用户点的菜由厨师来实现，这里**厨师就相当于是一个一个的子系统**。因此，用户通过菜单来决定吃什么，比直接去问厨师要简单的多。

# Facade（外观）模式的 UML 类图

![外观模式的 uml 类图](https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/facade.png)

 + Client：客户
 + Facade：高层次的接口
 + SubSystem：各个子系统，由 Facade 同一管理

# 外观模式的简单实现

根据前面提到的菜单的例子，那么就以菜单为例，实现一个简单的外观模式。首先是分析一下那个是高层接口，哪些是子系统？

 + 菜单通过统一管理菜系和菜品名，来向用户展示这家餐厅有什么菜，所以**菜单类应该为高层接口**
 + 各系菜系都有不同的实现，而且都属于同一家餐厅，所以**各系菜系为子系统**（或者说做菜的厨师也可以）

经过简单的分析过后，下面来实现一下这个案例

首先应该是实现各个子系统接口，这里假设这家餐厅有中，法，意三个菜系（那这家餐厅到底是中餐厅还是西餐厅？？？）

中国菜接口：ChineseCuisine
```java
public interface ChineseCuisine {

    /* 白切鸡 */
    public void boiledChickenwithSauce();

    /* 铁板牛肉 */
    public void sizzlingBeefSteak();

    /* 宫保鸡丁 */
    public void kungPaoChicken();

}
```

法国菜接口：FrenchCuisine
```java
public interface FrenchCuisine {

    /* 马赛鱼汤 */
    public void bouillabaisse();

    /* 豆焖肉 */
    public void cassoulet();

    /* 法式炖鸡 */
    public void pouleAuPot();

}
```

意大利接口：ItalyCuisine
```java
public interface ItalyCuisine {

    /* 焗茄汁千层面 */
    public void lasagneWithTomatoAndCheese();

    /* 虾仁烩饭 */
    public void prawnRisotto();

    /* 焦糖布丁 */
    public void creamCaramel();

}
```

接口内部只是简单的罗列了一下，接下来就是具体的实现了

中国菜实现类：ChineseCuisineImpl
```java
public class ChineseCuisineImpl implements ChineseCuisine {
    @Override
    public void boiledChickenWithSauce() {
        /* 准备材料; 加工材料; 烹饪; 装盘 */
        System.out.println("白切鸡");
    }

    @Override
    public void sizzlingBeefSteak() {
        /* 准备材料; 加工材料; 烹饪; 装盘 */
        System.out.println("铁板牛肉");
    }

    @Override
    public void kungPaoChicken() {
        /* 准备材料; 加工材料; 烹饪; 装盘 */
        System.out.println("宫保鸡丁");
    }
}
```

法国菜实现类：FrenchCuisineImpl
```java
public class FrenchCuisineImpl implements FrenchCuisine {
    @Override
    public void bouillabaisse() {
        System.out.println("马赛鱼汤");
    }

    @Override
    public void cassoulet() {
        System.out.println("豆焖肉");
    }

    @Override
    public void pouleAuPot() {
        System.out.println("法式炖鸡");
    }
}
```

意大利菜实现类：ItalyCuisineImpl
```java
public class ItalyCuisineImpl implements ItalyCuisine {
    @Override
    public void lasagneWithTomatoAndCheese() {
        System.out.println("焗茄汁千层面");
    }

    @Override
    public void prawnRisotto() {
        System.out.println("虾仁烩饭");
    }

    @Override
    public void creamCaramel() {
        System.out.println("焦糖布丁");
    }
}
```

**注意** 关于具体实现的细节，这里是用注释加以代替，但在实际开发中，应该根据具体情况而定

以上，菜就算“做”好了，下面该实现菜单类了

菜单类：Menu
```java
public class Menu {

    private ChineseCuisine chineseCuisine;
    private FrenchCuisine frenchCuisine;
    private ItalyCuisine italyCuisine;

    public Menu() {
        chineseCuisine = new ChineseCuisineImpl();
        frenchCuisine = new FrenchCuisineImpl();
        italyCuisine = new ItalyCuisineImpl();
    }

    public void boiledChickenWithSauce() {
        chineseCuisine.boiledChickenWithSauce();
    }

    public void sizzlingBeefSteak() {
        chineseCuisine.sizzlingBeefSteak();
    }

    public void kungPaoChicken() {
        chineseCuisine.kungPaoChicken();
    }


    public void bouillabaisse() {
        frenchCuisine.bouillabaisse();
    }

    public void cassoulet() {
        frenchCuisine.cassoulet();
    }

    public void pouleAuPot() {
        frenchCuisine.cassoulet();
    }

    public void lasagneWithTomatoAndCheese() {
        italyCuisine.lasagneWithTomatoAndCheese();
    }

    public void prawnRisotto() {
        italyCuisine.prawnRisotto();
    }

    public void creamCaramel() {
        italyCuisine.creamCaramel();
    }

}
```

经过以上的步骤过后，就可以简单的测试一下了
```java
Menu menu = new Menu();

System.out.println("客户一点餐：");
menu.boiledChickenWithSauce();
menu.lasagneWithTomatoAndCheese();
menu.sizzlingBeefSteak();


System.out.println("\n+-----------+\n");

System.out.println("客户二点餐：");
menu.cassoulet();
menu.pouleAuPot();
menu.creamCaramel();

```

测试结果如下
```console
客户一点餐：
白切鸡
焗茄汁千层面
铁板牛肉

+-----------+

客户二点餐：
豆焖肉
法式炖鸡
焦糖布丁
```

可见，Menu 的作用就是同一管理各个菜，通过一份菜单客户就可以点到各种各样的菜，降低了用户的使用（点餐）成本，使用起来更加简单


# 总结

通过将各个子系统封装起来，并通过一个高层次的结构向用户提供一个统一的 API 入口，使得这些子系统的使用更加的灵活并且降低了用户的使用成本。所以这里总结一下外观模式的优缺点：

 + 优点：向使用者或者用户隐藏具体实现细节，减少对子系统的联系，通过统一的管理，使得子系统易于使用

 + 缺点：因为管理着多个子系统，因此对于外观类来说，并没有遵循开闭原则，所以一旦业务出现变更，就需要直接修改外观类来适应变更

END.
