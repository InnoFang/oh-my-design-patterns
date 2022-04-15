/*
 * @FileName   : proxy/main.cpp
 * @CreateAt   : 2022/4/15
 * @Author     : Inno Fang
 * @Email      : innofang@yeah.net
 * @Description: Simple implementation of proxy pattern
 */

#include <iostream>

class Subject {
public:
    virtual ~Subject() = default;
    virtual void request() = 0;
};

class RealSubject : public Subject {
public:
    void request() override {
        std::cout << "request from RealSubject" << std::endl;
    }
};

class Proxy : public Subject {
public:
    explicit Proxy(RealSubject *subject) : _subject(subject) {}

    ~Proxy() override {
        delete _subject;
    }

    void request() override {
        check();
        _subject->request();
        done();
    }

    void check() {
        std::cout << "check access" << std::endl;
    }

    void done() {
        std::cout << "all done." << std::endl;
    }

private:
    RealSubject *_subject;
};

int main() {
    std::cout << "RealSubject:\n";
    RealSubject *realSubject = new RealSubject;
    realSubject->request();

    std::cout << "Proxy:\n";
    Proxy *proxy = new Proxy(realSubject);
    proxy->request();

    delete proxy;
    delete realSubject;
    return 0;
}
