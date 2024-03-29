cmake_minimum_required(VERSION 3.16)
project(design-patterns-for-cpp)

set(CMAKE_CXX_STANDARD 14)

# Creational Pattern
add_subdirectory(factory_method)
add_subdirectory(abstract_factory)
add_subdirectory(builder)
add_subdirectory(prototype)
add_subdirectory(singleton)

# Structural
add_subdirectory(adapter)
add_subdirectory(decorator)
add_subdirectory(facade)
add_subdirectory(flyweight)
add_subdirectory(proxy)

# Behavioral
add_subdirectory(template)
add_subdirectory(chain_of_responsibility)
add_subdirectory(iterator)
add_subdirectory(memento)
add_subdirectory(observer)
add_subdirectory(state)
add_subdirectory(strategy)
add_subdirectory(visitor)
