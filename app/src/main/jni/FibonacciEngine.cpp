//
// Created by fork on 28.07.15.
//

#include "FibonacciEngine.h"
#include "djinni_generated/cpp/fibonacci_engine_djinni.hpp"
#include "djinni_generated/cpp/fibonacci_callback_djinni.hpp"

namespace Fibonacci {

    std::shared_ptr<FibonacciEngineDjinni> FibonacciEngineDjinni::create_with_callback(const std::shared_ptr<FibonacciCallbackDjinni>& callback) {
        return std::make_shared<FibonacciEngine>(callback);
    }

    FibonacciEngine::FibonacciEngine (const std::shared_ptr<FibonacciCallbackDjinni> & callback) {
        this->m_callback = callback;
    }

    int64_t FibonacciEngine::computeFibonacci(int64_t limit) {
        m_callback->reportProgress(std::string("done"));
        return limit;
    }


}