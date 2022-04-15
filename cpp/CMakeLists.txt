cmake_minimum_required(VERSION 3.16)
project(design-patterns-for-cpp)

set(CMAKE_CXX_STANDARD 14)

# Creational Pattern
add_subdirectory(abstract_factory)
add_subdirectory(factory_method)
add_subdirectory(builder)
add_subdirectory(prototype)
add_subdirectory(singleton)

# Structural
add_subdirectory(adapter)
add_subdirectory(decorator)
add_subdirectory(proxy)
