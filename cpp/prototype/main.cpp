/*
 * @FileName   : prototype/main.cpp
 * @CreateAt   : 2022/4/9
 * @Author     : Inno Fang
 * @Email      : innofang@yeah.net
 * @Description: Simple implementation of Prototype pattern
 */

#include <iostream>
#include <string>

class Prototype {
public:
    Prototype() : _value("DEFAULT") {}

    virtual ~Prototype() = default;

    void setValue(const std::string &value) {
        _value = value;
    }

    virtual void show() = 0;

    virtual Prototype *clone() = 0;

protected:
    std::string _value;
};

class ConcretePrototype : public Prototype {
public:
    ConcretePrototype() = default;

    ~ConcretePrototype() = default;

    ConcretePrototype(const ConcretePrototype &rhs) : Prototype(rhs) {
        _value = rhs._value;
    }

    void setId(const size_t &id) {
        _id = id;
    }

    void show() override {
        std::cout << "ConcretePrototype with value (" << _value << ") has id: " << _id << std::endl;
    }

    ConcretePrototype *clone() override {
        return new ConcretePrototype(*this);
    }

private:
    size_t _id{};
};

int main() {
    Prototype *type_a = new ConcretePrototype();
    type_a->show();
    type_a->setValue("Concrete type A");
    type_a->show();

    ConcretePrototype *type_a_with_id = new ConcretePrototype();
    type_a_with_id->show();
    type_a_with_id->setId(123);
    type_a_with_id->show();

    delete type_a_with_id;
    delete type_a;

    return 0;
}