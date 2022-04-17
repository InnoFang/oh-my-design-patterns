/*
 * @FileName   : flyweight/main.cpp
 * @CreateAt   : 2022/4/17
 * @Author     : Inno Fang
 * @Email      : innofang@yeah.net
 * @Description: Simple implementation of flyweight pattern
 */

#include <iostream>
#include <string>
#include <unordered_map>
#include <initializer_list>

struct SharedState {
    std::string _movie;
    std::string _time;
    double _price;

    SharedState(const std::string &movie, const std::string &time, double price)
            : _movie(movie), _time(time), _price(price) {}

    friend std::ostream &operator<<(std::ostream &os, const SharedState &state) {
        return os << "[ " << state._movie << " , " << state._time << " , " << state._price << " ]";
    }
};

struct UniqueState {
    std::string _seat;
    std::string _no;

    UniqueState(const std::string &seat, const std::string &no)
            : _seat(seat), _no(no) {}

    friend std::ostream &operator<<(std::ostream &os, const UniqueState &state) {
        return os << "[ " << state._seat << " , " << state._no << " ]";
    }
};

class Flyweight {
public:
    Flyweight() {}
    Flyweight(const SharedState *sharedState)
    : _shared_state(new SharedState(*sharedState)) {}

    Flyweight(const Flyweight &other) : _shared_state(new SharedState(*other._shared_state)) {}

    ~Flyweight() {
        delete _shared_state;
    }

    SharedState *shared_state() const {
        return _shared_state;
    }

    void print(const UniqueState &unique_state) {
        std::cout << "Shared(" << *_shared_state << "), Unique(" << unique_state << ")." << std::endl;
    }

private:
    SharedState *_shared_state;
};

class FlyweightFactory {
public:
    FlyweightFactory(std::initializer_list<SharedState> shared_states) {
        for (const auto &ss: shared_states) {
            _flyweights.insert(std::make_pair(hash(ss), Flyweight(&ss)));
        }
    }

    Flyweight get(const SharedState &ss) {
        std::string key = hash(ss);
        if (!_flyweights.count(key)) {
            std::cout << "FlyweightFactory: Can't find a flyweight, creating new one.\n";
            _flyweights.insert(std::make_pair(key, Flyweight(&ss)));
        } else {
            std::cout << "FlyweightFactory: Reusing existing flyweight.\n";
        }
        return _flyweights[key];
    }

    void list() {
        std::cout << "\nFlyweightFactory: contains " << _flyweights.size() << " flyweight.\n";
        for (auto &flyweight: _flyweights) {
            std::cout << flyweight.first << std::endl;
        }
    }

private:
    std::string hash(const SharedState &ss) {
        return ss._movie + "_" + ss._time + "_" + std::to_string(ss._price);
    }

private:
    std::unordered_map<std::string, Flyweight> _flyweights;
};

int main() {
    auto *factory = new FlyweightFactory({
        {"Transformer5", "1:00pm", 9.5},
        {"Transformer5", "3:00pm", 10.5},
        {"Transformer5", "5:00pm", 11.5},
    });
    factory->list();
    std::cout << std::endl;

    auto ticket1 = factory->get({"Transformer5", "3:00pm", 10.5});
    ticket1.print({"A II", "NO.1"});

    auto ticket2 = factory->get({"Transformer5", "7:00pm", 12.5});
    ticket2.print({"D IV", "NO.22"});

    delete factory;
    return 0;
}