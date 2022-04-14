/*
 * @FileName   : decorator/main.cpp
 * @CreateAt   : 2022/4/14
 * @Author     : Inno Fang
 * @Email      : innofang@yeah.net
 * @Description: Simple implementation of decorator pattern
 */

#include <iostream>
#include <string>

class Component {
public:
    virtual ~Component() = default;

    virtual std::string operation() = 0;
};

class ConcreteComponent : public Component {
public:
    std::string operation() override {
        return "ConcreteComponent";
    }
};

class Decorator : public Component {
public:
    explicit Decorator(Component *component)
            : _component(component) {}

    std::string operation() override {
        return _component->operation();
    }

protected:
    Component *_component;
};

class ConcreteDecoratorA : public Decorator {
public:
    explicit ConcreteDecoratorA(Component *component)
            : Decorator(component) {}

    std::string operation() override {
        return "ConcreteDecoratorA(" + Decorator::operation() + ")";
    }
};

class ConcreteDecoratorB : public Decorator {
public:
    explicit ConcreteDecoratorB(Component *component)
            : Decorator(component) {}

    std::string operation() override {
        return "ConcreteDecoratorB(" + Decorator::operation() + ")";
    }
};

int main() {
    Component *simple = new ConcreteComponent;
    std::cout << "Simple component:" << std::endl;
    std::cout << simple->operation() << std::endl;
    std::cout << std::endl;

    Decorator *decoratorA = new ConcreteDecoratorA(simple);
    Decorator *decoratorB = new ConcreteDecoratorB(decoratorA);
    std::cout << "Decorator component:" << std::endl;
    std::cout << decoratorB->operation() << std::endl;

    delete decoratorB;
    delete decoratorA;
    delete simple;
    return 0;
}
