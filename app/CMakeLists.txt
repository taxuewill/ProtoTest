cmake_minimum_required(VERSION 3.6)

add_compile_options(-std=c++11)


message(STATUS "Hello,Cmake!!!")
set(my_lib_path ${CMAKE_SOURCE_DIR}/libs)

include_directories(src/main/jni)

add_library(protobuf
    STATIC
    IMPORTED)

set_target_properties(protobuf
    PROPERTIES IMPORTED_LOCATION
    ${my_lib_path}/libprotobuf.a)

add_library(protobuf_lite
    STATIC
    IMPORTED)
set_target_properties(protobuf_lite
    PROPERTIES IMPORTED_LOCATION
    ${my_lib_path}/libprotobuf-lite.a)

add_library(
    xjni
    SHARED
    src/main/jni/xjni.cpp
    src/main/jni/Person.pb.cc
    src/main/jni/NestedEntry.pb.cc
    )

find_library(
    log-lib
    log )

target_include_directories(xjni
    INTERFACE
    ${CMAKE_CURRENT_SOURCE_DIR}/src/main/jni)

target_link_libraries(
    xjni
    ${log-lib}
    protobuf
    protobuf_lite)