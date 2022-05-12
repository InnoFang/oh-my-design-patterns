/*
 * @FileName   : iterator/main.cpp
 * @CreateAt   : 2022/5/12
 * @Author     : Inno Fang
 * @Email      : innofang@yeah.net
 * @Description: Simple implementation of iterator pattern
 */

#include <iostream>
#include <vector>

template<typename T, typename C>
class Iterator {
public:
    typedef typename std::vector<T>::iterator iter_type;

    explicit Iterator(C *container) : _container(container) {
        _iter = _container->_data.begin();
    }

    void first() {
        _iter = _container->_data.begin();
    }

    void next() {
        _iter++;
    }

    bool done() {
        return _iter == _container->_data.end();
    }

    iter_type current() {
        return _iter;
    }

private:
    C *_container;
    iter_type _iter;
};

template<class T>
class Container {
    friend class Iterator<T, Container>;

public:
    void add(T t) {
        _data.push_back(t);
    }

    Iterator<T, Container> *iterator() {
        return new ::Iterator<T, Container>(this);
    }

private:
    std::vector<T> _data;
};

class Data {
public:
    explicit Data(int val = 0) : _val(val) {}

    void setValue(int val) {
        _val = val;
    }

    int value() {
        return _val;
    }

private:
    int _val;
};

int main() {
    std::cout << "__________  iterator with int  __________" << std::endl;
    Container<int> cont1;

    for (int i = 0; i < 10; ++i) {
        cont1.add(i);
    }

    Iterator<int, Container<int>> *it1 = cont1.iterator();
    for (it1->first(); !it1->done(); it1->next()) {
        std::cout << *it1->current() << std::endl;
    }

    std::cout << "__________  iterator with Custom Class  __________" << std::endl;
    Container<Data> cont2;
    Data a(100), b(200), c(300);
    cont2.add(a);
    cont2.add(b);
    cont2.add(c);

    Iterator<Data, Container<Data>> *it2 = cont2.iterator();
    for (it2->first(); !it2->done(); it2->next()) {
        std::cout << it2->current()->value() << std::endl;
    }

    delete it1;
    delete it2;
    return 0;
}
