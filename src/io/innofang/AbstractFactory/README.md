# Abstract Factory（抽象工厂）

在此之前，已经学习过了<a href="https://github.com/InnoFang/DesignPatterns/tree/master/src/io/innofang/FactoryMethod">Factory Method（工厂方法）</a>，抽象工厂和工厂方法这两个模式都属于创建型设计模式，那么根据[工厂]这个词，大概也能猜出这两个模式都是用来“生产”的

那么这两种用来“生产”的模式 ——— 抽象工厂和工厂方法，这两个设计模式有什么区别呢？或者说也两个模式“生产”的东西有什么不同的吗？

在之前工厂方法的简单实现中，举了个工厂制作蛋糕的例子，蛋糕店需要生产两种蛋糕，分别为草莓口味的红色的爱心型蛋糕和芒果口味的黄色的方形蛋糕，这两个都是具体的产品，