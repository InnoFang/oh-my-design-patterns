/*
 * @FileName   : visitor/main.cpp
 * @CreateAt   : 2022/11/26
 * @Author     : Inno Fang
 * @Email      : innofang@yeah.net
 * @Description: 
 */

#include <iostream>
#include <vector>

class ConcreteComponentA;
class ConcreteComponentB;

class Visitor {
public:
    virtual void visit(const ConcreteComponentA *element) const = 0;
    virtual void visit(const ConcreteComponentB *element) const = 0;
};

class Component {
public:
    virtual ~Component() = default;
    virtual void accept(Visitor *visitor) const = 0;
};

class ConcreteComponentA: public Component {
public:
    void accept(Visitor *visitor) const override {
        visitor->visit(this);
    }

    std::string foo() const {
        return "foo" ;
    }
};

class ConcreteComponentB: public Component {
public:
    void accept(Visitor *visitor) const override {
        visitor->visit(this);
    }
    std::string bar() const {
        return "bar";
    }
};

class ConcreteVisitor1 : public Visitor {
public:
    void visit(const ConcreteComponentA *element) const override {
        std::cout << "Call ConcreteComponentA's " << element->foo() << " by ConcreteVisitor1" << std::endl;
    }

    void visit(const ConcreteComponentB *element) const override {
        std::cout << "Call ConcreteComponentB's bar: " << element->bar() << " by ConcreteVisitor1" << std::endl;
    }
};

class ConcreteVisitor2 : public Visitor {
public:
    void visit(const ConcreteComponentA *element) const override {
        std::cout << "Call ConcreteComponentA's " << element->foo() << " by ConcreteVisitor2" << std::endl;
    }

    void visit(const ConcreteComponentB *element) const override {
        std::cout << "Call ConcreteComponentB's bar: " << element->bar() << " by ConcreteVisitor2" << std::endl;
    }
};

int main() {
    std::vector<const Component*> components = {
            new ConcreteComponentA,
            new ConcreteComponentB
    };
    auto *visitor1 = new ConcreteVisitor1;
    for (const auto comp: components) {
        comp->accept(visitor1);
    }

    auto *visitor2 = new ConcreteVisitor2;
    for (const auto comp: components) {
        comp->accept(visitor2);
    }

    for (const auto comp: components) {
        delete comp;
    }

    delete visitor1;
    delete visitor2;
    return 0;
}