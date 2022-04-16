/*
 * @FileName   : facade/main.cpp
 * @CreateAt   : 2022/4/16
 * @Author     : Inno Fang
 * @Email      : innofang@yeah.net
 * @Description: Simple implementation of facade pattern
 */
#include <iostream>

class SubSystemA {
public:
    void operationA() {
        std::cout << "SubSystemA: operationA" << std::endl;
    }
};

class SubSystemB {
public:
    void operationB() {
        std::cout << "SubSystemB: operationB" << std::endl;
    }
};

class Facade {
public:
    Facade(SubSystemA *subSystemA = nullptr, SubSystemB *subSystemB = nullptr) {
        _sub_system_a = subSystemA ? subSystemA : new SubSystemA;
        _sub_system_b = subSystemB ? subSystemB : new SubSystemB;
    }

    ~Facade() {
        delete _sub_system_a;
        delete _sub_system_b;
    }

    void operationA() {
        _sub_system_a->operationA();
    }

    void operationB() {
        _sub_system_b->operationB();
    }

    void operationMix() {
        std::cout << "Mix operationA and operationB:" << std::endl;
        std::cout << "=> Ready perform operationA:" << std::endl;
        _sub_system_a->operationA();
        std::cout << "=> Ready perform operationB:" << std::endl;
        _sub_system_b->operationB();
    }

private:
    SubSystemA *_sub_system_a;
    SubSystemB *_sub_system_b;
};

int main() {
    auto facade = new Facade;
    std::cout << "\nPerform operationA separately" << std::endl;
    facade->operationA();
    std::cout << "\nPerform operationB separately" << std::endl;
    facade->operationB();
    std::cout << "\nPerform by mixing operation" << std::endl;
    facade->operationMix();

    delete facade;
    return 0;
}
