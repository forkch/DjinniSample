//
// Created by fork on 28.07.15.
//

#ifndef DJINNIDEMO_FIBONACCIENGINE_H
#define DJINNIDEMO_FIBONACCIENGINE_H

#include "fibonacci_engine_djinni.hpp"


namespace Fibonacci {

    class FibonacciEngine : public FibonacciEngineDjinni {

    public:

        FibonacciEngine(const std::shared_ptr<FibonacciCallbackDjinni> & callback);
        virtual int64_t computeFibonacci(int64_t limit);

    private:
        std::shared_ptr<FibonacciCallbackDjinni> m_callback;

    };

}
#endif //DJINNIDEMO_FIBONACCIENGINE_H
