/*
 * @FileName   : adapter/main.cpp
 * @CreateAt   : 2022/4/13
 * @Author     : Inno Fang
 * @Email      : innofang@yeah.net
 * @Description: Simple implementation of adapter pattern
 */

#include <iostream>


class Target {
public:
    virtual void request() = 0;

    virtual ~Target() = default;
};

class Adaptee {
public:
    void specificRequest() {
        std::cout << "Adaptee" << std::endl;
    }
};

class Adapter : public Target {
public:
    Adapter() {
        _adaptee = new Adaptee();
    }

    ~Adapter() {
        delete _adaptee;
    }

    void request() override {
        _adaptee->specificRequest();
    };

private:
    Adaptee *_adaptee;
};

int main() {
    Target *target = new Adapter();
    target->request();

    delete target;
    return 0;
}
