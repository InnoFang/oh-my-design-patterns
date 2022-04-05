/*
 * @FileName   : abstract_factory/main.cpp
 * @CreateAt   : 2022/4/4
 * @Author     : Inno Fang
 * @Email      : innofang@yeah.net
 * @Description: Simple implementation of abstract factory
 */

#include <iostream>

class ProductAInterface {
public:
    virtual void doA() = 0;
};

class ProductBInterface {
public:
    virtual void doB() = 0;
};



class ConcreteProductA1 : public ProductAInterface {
public:
    void doA() override {
        std::cout << "Create Product A1" << std::endl;
    }
};

class ConcreteProductA2 : public ProductAInterface {
public:
    void doA() override {
        std::cout << "Create Product A2" << std::endl;
    }
};

class ConcreteProductB1 : public ProductBInterface {
public:
    void doB() override {
        std::cout << "Create Product B1" << std::endl;
    }
};

class ConcreteProductB2 : public ProductBInterface {
public:
    void doB() override {
        std::cout << "Create Product B2" << std::endl;
    }
};


class FactoryInterface {
public:
    virtual ProductAInterface* createProductA() = 0;
    virtual ProductBInterface* createProductB() = 0;
};


class ConcreteFactory1 : public FactoryInterface {
public:
    ProductAInterface* createProductA() override {
        return new ConcreteProductA1();
    }

    ProductBInterface* createProductB() override {
        return new ConcreteProductB1();
    }
};

class ConcreteFactory2 : public FactoryInterface {
public:
    ProductAInterface* createProductA() override {
        return new ConcreteProductA2();
    }

    ProductBInterface* createProductB() override {
        return new ConcreteProductB2();
    }
};


int main() {

    std::cout << "==> Case 1:" << std::endl;
    FactoryInterface *factory1 = new ConcreteFactory1();
    ProductAInterface *product_a1 = factory1->createProductA();
    ProductBInterface *product_b1 = factory1->createProductB();
    product_a1->doA();
    product_b1->doB();

    std::cout << "\n==> Case 2:" << std::endl;
    FactoryInterface *factory2 = new ConcreteFactory2();
    ProductAInterface *product_a2 = factory2->createProductA();
    ProductBInterface *product_b2 = factory2->createProductB();
    product_a2->doA();
    product_b2->doB();

    return 0;
}