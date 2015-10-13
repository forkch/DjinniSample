//
// Created by fork on 28.07.15.
//

#include <vector>
#include "FibonacciEngine.hpp"
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

        int64_t input(0), a(0), b(1), total(1);

        std::vector<int64_t> chunk;

        for (int64_t i = 0; i <= amount; i++) {
            total = a + b;
            a = b;
            b = total;
            chunk.push_back(total);
            if (chunk.size() == 10) {
                m_callback->reportProgress(chunk);
                chunk.clear();
            }
           std::this_thread::sleep_for(std::chrono::milliseconds(100));


        }
        m_callback->reportProgress(chunk);
        return total;
    }
}