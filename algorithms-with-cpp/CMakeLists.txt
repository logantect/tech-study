cmake_minimum_required(VERSION 3.29)
project(algorithms-with-cpp)

set(CMAKE_CXX_STANDARD 20)

add_executable(barkingdog main.cpp)

add_executable(0x01_time_complexity basic-algo-lecture/0x01/time_complexity.cpp)
add_executable(array_test basic-algo-lecture/0x03/array_test.cpp)
add_executable(vector_example basic-algo-lecture/0x03/vector_example.cpp)
add_executable(10808_1 basic-algo-lecture/0x03/boj/10808_1.cpp)
add_executable(10808_2 basic-algo-lecture/0x03/boj/10808_2.cpp)
add_executable(func2_soluction basic-algo-lecture/0x03/func2_soluction.cpp)
add_executable(Fibonacci mastering-data-structures/0x05-Recursion/Fibonacci.cpp)