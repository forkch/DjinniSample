// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from fibonacci.djinni

#pragma once

#include <string>

namespace Fibonacci {

class FibonacciCallbackDjinni {
public:
    virtual ~FibonacciCallbackDjinni() {}

    virtual void reportProgress(const std::string & progress) = 0;
};

}  // namespace Fibonacci