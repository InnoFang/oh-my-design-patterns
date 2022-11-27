/*
 * @FileName   : main.cpp 
 * @CreateAt   : 2022/11/27
 * @Author     : Inno Fang
 * @Email      : innofang@yeah.net
 * @Description: 
 */

#include <iostream>
#include <string>
#include <vector>

class Handler {
public:
    virtual Handler *next(Handler *Handler) = 0;
    virtual std::string handle(const std::string &request) = 0;
};

class AbstractHandler: public Handler {
public:
    AbstractHandler() : _next_handler(nullptr) {}

    Handler *next(Handler *handler) override {
        _next_handler = handler;
        return _next_handler;
    }

    std::string handle(const std::string &request) override {
        if (_next_handler) {
            return _next_handler->handle(request);
        }
        return {};
    }

private:
    Handler *_next_handler;
};

class MonkeyHandler : public AbstractHandler {
public:
    std::string handle(const std::string &request) override {
        if (request == "Banana") {
            return "Monkey: I'll eat the " + request + ".\n";
        } else {
            return AbstractHandler::handle(request);
        }
    }
};

class SquirrelHandler : public AbstractHandler {
public:
    std::string handle(const std::string &request) override {
        if (request == "Nut") {
            return "Squirrel: I'll eat the " + request + ".\n";
        } else {
            return AbstractHandler::handle(request);
        }
    }
};

class DogHandler : public AbstractHandler {
public:
    std::string handle(const std::string &request) override {
        if (request == "MeatBall") {
            return "Dog: I'll eat the " + request + ".\n";
        } else {
            return AbstractHandler::handle(request);
        }
    }
};

void ClientCode(Handler &handler) {
    std::vector<std::string> food = {"Nut", "Banana", "Cup of coffee"};
    for (const std::string &f : food) {
        std::cout << "Client: Who wants a " << f << "?\n";
        const std::string result = handler.handle(f);
        if (!result.empty()) {
            std::cout << "  " << result;
        } else {
            std::cout << "  " << f << " was left untouched.\n";
        }
    }
}

int main() {
    auto *monkey = new MonkeyHandler;
    auto *squirrel = new SquirrelHandler;
    auto *dog = new DogHandler;
    monkey->next(squirrel)->next(dog);

    std::cout << "Chain: Monkey > Squirrel > Dog\n\n";
    ClientCode(*monkey);
    std::cout << "\n";
    std::cout << "Subchain: Squirrel > Dog\n\n";
    ClientCode(*squirrel);

    delete monkey;
    delete squirrel;
    delete dog;
    return 0;
}