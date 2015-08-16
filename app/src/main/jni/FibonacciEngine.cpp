//
// Created by fork on 28.07.15.
//

#include <vector>
#include "FibonacciEngine.h"
#include "djinni_generated/cpp/fibonacci_engine_djinni.hpp"
#include "djinni_generated/cpp/fibonacci_callback_djinni.hpp"

#include <chrono>
#include <thread>

namespace Fibonacci {

    std::shared_ptr<FibonacciEngineDjinni> FibonacciEngineDjinni::create_with_callback(
            const std::shared_ptr<FibonacciCallbackDjinni> &callback) {
        return std::make_shared<FibonacciEngine>(callback);
    }

    FibonacciEngine::FibonacciEngine(const std::shared_ptr<FibonacciCallbackDjinni> &callback) {
        this->m_callback = callback;
    }

    int64_t FibonacciEngine::computeFibonacci(int64_t amount) {

        int input(0), Alpha(0), Beta(1), Total(1);

        std::vector<int64_t> chunk;

        for (int i = 0; i <= amount; i++) {
            Total = Alpha + Beta;
            Alpha = Beta;
            Beta = Total;
            chunk.push_back(Total);
            if (chunk.size() == 10) {
                m_callback->reportProgress(chunk);
                chunk.clear();
            }
           std::this_thread::sleep_for(std::chrono::milliseconds(100));


        }
        m_callback->reportProgress(chunk);
        return Total;
    }
}