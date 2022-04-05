/*
 * @FileName   : factory_method/main.cpp
 * @CreateAt   : 2022/4/4
 * @Author     : Inno Fang
 * @Email      : innofang@yeah.net
 * @Description: Simple implementation of factory method
 */

#include <iostream>

typedef enum ProductType {
    TYPE_A,
    TYPE_B,
    TYPE_C
} ProductType_t;


class ProductInterface {
public:
    virtual void use() = 0;
};


class ConcreteProductA : public ProductInterface {
public:
    void use() override {
        std::cout << "Use productA" << std::endl;
    }
};

class ConcreteProductB : public ProductInterface {
public:
    void use() override {
        std::cout << "Use productB" << std::endl;
    }
};

class ConcreteProductC : public ProductInterface {
public:
    void use() override {
        std::cout << "Use productC" << std::endl;
    }
};


class FactoryInterface {
public:
    virtual ProductInterface* createProduct(ProductType_t) = 0;
};


class ConcreteFactory : public FactoryInterface {
public:
    ProductInterface* createProduct(ProductType_t type) override {
        switch (type) {
            case TYPE_A:
                return new ConcreteProductA();
            case TYPE_B:
                return new ConcreteProductB();
            case TYPE_C:
                return new ConcreteProductC();
            default:
                return nullptr;
        }
    }
};


int main() {
    FactoryInterface *factory = new ConcreteFactory();
    ProductInterface *product = factory->createProduct(ProductType_t::TYPE_A);
    if (product) product->use();

    product = factory->createProduct(ProductType_t::TYPE_B);
    if (product) product->use();

    product = factory->createProduct(ProductType_t::TYPE_C);
    if (product) product->use();

    return 0;
}
