/*
 * @FileName   : main.cpp 
 * @CreateAt   : 2022/4/5
 * @Author     : Inno Fang
 * @Email      : innofang@yeah.net
 * @Description: 
 */

#include <iostream>
#include <string>

class Product {
public:
    size_t getId() const {
        return _id;
    }

    void setId(size_t id) {
        _id = id;
    }

    double getWeight() const {
        return _weight;
    }

    void setWeight(double weight) {
        _weight = weight;
    }

    const std::string &getType() const {
        return _type;
    }

    void setType(const std::string &type) {
        _type = type;
    }

    friend std::ostream &operator<<(std::ostream &os, const Product &product) {
        os << "id: " << product._id << " weight: " << product._weight << " type: " << product._type;
        return os;
    }

private:
    size_t _id;
    double _weight;
    std::string _type;
};


class Builder {
public:
    virtual void buildId(size_t id) = 0;

    virtual void buildWeight(double weight) = 0;

    virtual void buildType(const std::string &type) = 0;

    virtual Product *create() = 0;
};

class ConcreteBuilder : public Builder {
public:
    ConcreteBuilder()
            : _product(new Product()) {}

    void buildId(size_t id) override {
        _product->setId(id);
    }

    void buildWeight(double weight) override {
        _product->setWeight(weight);
    }

    void buildType(const std::string &type) override {
        _product->setType(type);
    }

    Product *create() override {
        return _product;
    }

private:
    Product *_product;
};


class Director {
public:
    explicit Director(Builder *builder)
            : _builder(builder) {}

    void construct(size_t id, double weight, const std::string &type) {
        _builder->buildId(id);
        _builder->buildWeight(weight);
        _builder->buildType(type);
    }

private:
    Builder *_builder;
};


int main() {
    Builder *builder = new ConcreteBuilder();
    auto *director = new Director(builder);
    director->construct(1, 12.3, "typeA");
    Product *product = builder->create();
    std::cout << *product << std::endl;

    return 0;
}