/*
 * @FileName   : observer/main.cpp
 * @CreateAt   : 2022/11/25
 * @Author     : Inno Fang
 * @Email      : innofang@yeah.net
 * @Description: 
 */
#include <iostream>
#include <list>
#include <string>

class IObserver {
public:
    virtual ~IObserver() = default;

    virtual bool update(const std::string &msg) = 0;
};

class ISubject {
public:
    virtual ~ISubject() = default;

    virtual void attach(IObserver *observer) = 0;

    virtual void detach(IObserver *observer) = 0;

    virtual void notify() = 0;
};

class Subject : public ISubject {
public:
    ~Subject() override {
        std::cout << "Deconstruction from Subject" << std::endl;
    }

    void attach(IObserver *observer) override {
        _observers.push_back(observer);
    }

    void detach(IObserver *observer) override {
        _observers.remove(observer);
    }

    void notify() override {
        std::cout << "There are " << _observers.size() << " observers." << std::endl;
        size_t affect = 0;
        for (const auto &observer: _observers) {
            affect += observer->update(_message) ? 1 : 0;
        }
        std::cout << affect << " observer(s)' have been notified." << std::endl;
    }

    void setMessage(const std::string &msg = "") {
        if (msg.empty()) return;
        _message = msg;
        notify();
    }

private:
    std::list<IObserver *> _observers;
    std::string _message;
};

class Observer : public IObserver {
public:
    Observer(int id, Subject &subject) : _id(id), _subject(subject) {
        subscribe(subject);
    }

    ~Observer() override {
        std::cout << "Deconstruction from Observer " << _id << std::endl;
    }

    bool update(const std::string &msg) override {
        // if update the _message failed, return false, otherwise go ahead.
        _message = msg;
        std::cout << "Observer " << _id << " got new message: " << _message << std::endl;
        return true;
    }

    void subscribe(Subject &subject) {
        if (&subject != &_subject) {
            _subject = subject;
        }
        _subject.attach(this);
        std::cout << "Observer " << _id << " subscribe the subject." << std::endl;
    }

    void unsubscribe() {
        _subject.detach(this);
        std::cout << "Observer " << _id << " ubsubscribe the subject." << std::endl;
    };

private:
    int _id;
    std::string _message;
    Subject &_subject;
};

int main() {
    auto *subject = new Subject;
    auto *observer1 = new Observer(1, *subject);
    auto *observer2 = new Observer(2, *subject);
    auto *observer3 = new Observer(3, *subject);

    subject->setMessage("Hello World!");
    observer1->unsubscribe();

    subject->setMessage("It's a nice day!");

    auto *observer4 = new Observer(4, *subject);

    subject->setMessage("Good luck for you all!");

    observer2->unsubscribe();
    observer3->unsubscribe();
    observer4->unsubscribe();

    delete observer1;
    delete observer2;
    delete observer3;
    delete observer4;
    delete subject;
    return 0;
}