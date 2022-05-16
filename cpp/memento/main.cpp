/*
 * @FileName   : memento/main.cpp
 * @CreateAt   : 2022/5/16
 * @Author     : Inno Fang
 * @Email      : innofang@yeah.net
 * @Description: Simple implementation of memento pattern
 */
#include <iostream>
#include <string>
#include <ctime>
#include <vector>

class Memento {
public:
    Memento(std::string &info, std::string &state) : _info(info), _state(state) {
        std::time_t now = std::time(0);
        _date = std::ctime(&now);
    }

    std::string info() const {
        return _info;
    }

    std::string state() const {
        return _state;
    }

    std::string date() const {
        return _date;
    }

    friend std::ostream &operator<<(std::ostream &out, const Memento &memento) {
        return out << "[ info:" + memento._info << ", state:" + memento._state + ", date:" + memento._date + " ]";
    }

private:
    std::string _info;
    std::string _state;
    std::string _date;
};

class Originator {
public:
    Originator() = default;

    void recordInfoDetail(const std::string &info, const std::string &state) {
        _info = info;
        _state = state;
    }

    Memento *save() {
        return new Memento(_info, _state);
    }

    void restore(Memento *memento) {
        _state = memento->state();
        _info = memento->info();
        _date = memento->date();
    }

private:
    std::string _state;
    std::string _info;
    std::string _date;
};

class CareTaker {
public:
    explicit CareTaker(Originator *originator) : _originator(originator) {}

    void backUp() {
        _mementos.emplace_back(_originator->save());
    }

    void undo() {
        if (_mementos.empty()) return;
        Memento *memento = _mementos.back();
        _mementos.pop_back();
        _originator->restore(memento);
    }

    void showHistory() const {
        for (auto memento: _mementos) {
            std::cout << (*memento) << std::endl;
        }
    }

private:
    Originator *_originator;
    std::vector<Memento *> _mementos;
};

int main() {
    Originator *originator = new Originator;
    CareTaker *careTaker = new CareTaker(originator);
    originator->recordInfoDetail("Study at 2:00pm", "Done!");
    careTaker->backUp();
    originator->recordInfoDetail("Do some sports at 4:00pm", "Have fun!");
    careTaker->undo();
    originator->recordInfoDetail("Read some books at 4:00pm", "Have to study hard!");
    careTaker->backUp();
    originator->recordInfoDetail("Eat dinner at 6:00pm", "Delicious");
    careTaker->backUp();

    careTaker->showHistory();

    delete careTaker;
    delete originator;
    return 0;
}