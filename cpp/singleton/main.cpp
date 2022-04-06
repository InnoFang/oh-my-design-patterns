/*
 * @FileName   : singleton/main.cpp
 * @CreateAt   : 2022/4/6
 * @Author     : Inno Fang
 * @Email      : innofang@yeah.net
 * @Description: 
 */

#include <iostream>

class SingletonBase {
public:
    SingletonBase(const SingletonBase &) = delete;

    SingletonBase &operator=(const SingletonBase &) = delete;

public:
    static SingletonBase *get_instance() {
        if (_instance == nullptr) {
            _instance = new SingletonBase();
        }
        return _instance;
    }

private:
    SingletonBase() = default;

    static SingletonBase *_instance;
};

class SingletonBaseRAII {
public:
    SingletonBaseRAII(const SingletonBaseRAII &) = delete;

    SingletonBaseRAII &operator=(const SingletonBaseRAII &) = delete;

public:
    static SingletonBaseRAII *get_instance() {
        if (_instance == nullptr) {
            _instance = new SingletonBaseRAII();
        }
        return _instance;
    }

private:
    SingletonBaseRAII() = default;

    static SingletonBaseRAII *_instance;

    class GC {
    public:
        ~GC() {
            // `if` statement is unnecessary; deleting null pointer has no effect
//            if (_instance != nullptr) {
//                delete _instance;
//            }
            delete _instance;
        }
    };

    static GC _gc;
};

#include <mutex>

std::mutex mtx;

class SingletonThreadSafe {
public:
    SingletonThreadSafe(const SingletonThreadSafe &) = delete;

    SingletonThreadSafe &operator=(const SingletonThreadSafe &) = delete;

public:
    static SingletonThreadSafe *get_instance() {
        if (_instance == nullptr) {
            mtx.lock();
            if (_instance == nullptr) {
                _instance = new SingletonThreadSafe();
            }
            mtx.unlock();
        }
        return _instance;
    }

private:
    SingletonThreadSafe() = default;

    static SingletonThreadSafe *_instance;

    class GC {
    public:
        ~GC() {
            delete _instance;
        }
    };

    static GC _gc;
};

class SingletonStatic {
public:
    SingletonStatic(const SingletonStatic &) = delete;

    SingletonStatic &operator=(const SingletonStatic &) = delete;

public:
    static SingletonStatic *get_instance() {
        static SingletonStatic instance;
        return &instance;
    }

private:
    SingletonStatic() = default;

    ~SingletonStatic() = default;
};

template<typename T>
class Singleton {
public:
    Singleton(const Singleton &) = delete;

    Singleton &operator=(const Singleton &) = delete;

public:
    static T &get_instance() {
        static T value_;
        return value_;
    }

private:
    Singleton() = default;

    ~Singleton() = default;
};

class A {
public:
    A() { a = 1; }
    void show() { std::cout << "A.a=" << a << std::endl; }
private:
    int a;
};

int main() {
//    std::cout << "\n==> SingletonBase" << std::endl;
//    std::cout << (SingletonBase::get_instance() == SingletonBase::get_instance()) << std::endl;
//
//    std::cout << "\n==> Singleton base RAII" << std::endl;
//    std::cout << (SingletonBaseRAII::get_instance() == SingletonBaseRAII::get_instance()) << std::endl;
//
//    std::cout << "\n==> Singleton with Thread safety" << std::endl;
//    std::cout << (SingletonThreadSafe::get_instance() == SingletonThreadSafe::get_instance()) << std::endl;

    // best singleton!
    std::cout << "\n==> Singleton Static" << std::endl;
    std::cout << (SingletonStatic::get_instance() == SingletonStatic::get_instance()) << std::endl;

    std::cout << "\n==> Singleton with template" << std::endl;
    Singleton<A>::get_instance().show();
    return 0;
}
