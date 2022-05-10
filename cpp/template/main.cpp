/*
 * @FileName   : template/main.cpp
 * @CreateAt   : 2022/5/10
 * @Author     : Inno Fang
 * @Email      : innofang@yeah.net
 * @Description: Simple implementation of template method
 */

#include <iostream>

class AbstractClass {
public:
    void templateMethod() const {
        baseOperation1();
        requireOperation1();
        baseOperation2();
        hook1();
        requireOperation2();
        hook2();
    }

protected:
    void baseOperation1() const {
        std::cout << "AbstractClass says: I am doing the bulk of the work" << std::endl;
    }

    void baseOperation2() const {
        std::cout << "AbstractClass says: But I let " << std::endl;
    }

    virtual void requireOperation1() const = 0;

    virtual void requireOperation2() const = 0;

    virtual void hook1() const {}

    virtual void hook2() const {}
};


class ConcreteClass : public AbstractClass {
protected:
    void requireOperation1() const override {
        std::cout << "ConcreteClass says: Implemented Operation1" << std::endl;
    }

    void requireOperation2() const override {
        std::cout << "ConcreteClass says: Implemented Operation2" << std::endl;
    }

    void hook1() const override {
        std::cout << "ConcreteClass says: Overridden hook1" << std::endl;
    }
};

int main() {
    ConcreteClass *concreteClass = new ConcreteClass;
    concreteClass->templateMethod();
    delete concreteClass;
    return 0;
}
