/*
 * @FileName   : strategy/main.cpp
 * @CreateAt   : 2022/4/18
 * @Author     : Inno Fang
 * @Email      : innofang@yeah.net
 * @Description: Simple implementation of strategy pattern
 */

#include <iostream>
#include <string>
#include <vector>

class Strategy {
public:
    virtual ~Strategy() = default;

    virtual std::string take() = 0;
};

class BusStrategy : public Strategy {
public:
    std::string take() override {
        return "bus";
    }
};

class CarStrategy : public Strategy {
public:
    std::string take() override {
        return "car";
    }
};

class Context {
public:
    Context(Strategy *strategy = nullptr) : _strategy(strategy) {}

    ~Context() {
        delete _strategy;
    }

    void set_strategy(Strategy *strategy) {
        delete _strategy;
        _strategy = strategy;
    }

    void operation() {
        std::cout << "Go outside and the transportation choice is [ " + _strategy->take() << " ].\n";
    }

private:
    Strategy *_strategy;
};

int main() {
    Context *context = new Context(new BusStrategy);
    std::cout << "==> Default transportation is bus.\n";
    context->operation();

    std::cout << "==> switch transportation from bus to car.\n";
    context->set_strategy(new CarStrategy);
    context->operation();

    delete context;
    return 0;
}