/*
 * @FileName   : state/main.cpp
 * @CreateAt   : 2022/4/19
 * @Author     : Inno Fang
 * @Email      : innofang@yeah.net
 * @Description: Simple implementation of State pattern
 */

#include <iostream>

class Context;

class State {
public:
    virtual ~State() {};

    void setContext(Context *context) {
        _context = context;
    }

    virtual void handle1() = 0;

    virtual void handle2() = 0;

protected:
    Context *_context;
};

class Context {
public:
    ~Context() {
        delete _state;
    }

    void setState(State *state) {
        delete _state;
        _state = state;
        _state->setContext(this);
    }

    void request1() {
        _state->handle1();
    }

    void request2() {
        _state->handle2();
    }

private:
    State *_state;
};


class ConcreteStateA : public State {
public:
    void handle1() override;

    void handle2() override {
        std::cout << "ConcreteStateA handles request2.\n";
    }
};

class ConcreteStateB : public State {
public:
    void handle1() override {
        std::cout << "ConcreteStateB handles request1.\n";
    }

    void handle2() override {
        std::cout << "ConcreteStateB handles request2.\n";
        std::cout << "ConcreteStateB wants to change the state of the context.\n";
        _context->setState(new ConcreteStateA);
    }
};

void ConcreteStateA::handle1() {
    std::cout << "ConcreteStateA handles request1.\n";
    std::cout << "ConcreteStateA wants to change the state of the context.\n";
    _context->setState(new ConcreteStateB());
}


int main() {
    Context *context = new Context();
    context->setState(new ConcreteStateA);
    context->request1();
    context->request2();
    return 0;
}
