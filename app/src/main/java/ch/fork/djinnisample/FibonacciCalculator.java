package ch.fork.djinnisample;

import ch.fork.djinnisample.djinni_generated.FibonacciCallbackDjinni;
import ch.fork.djinnisample.djinni_generated.FibonacciEngineDjinni;
import timber.log.Timber;

/**
 * Created with love by fork on 28.07.15.
 */
public class FibonacciCalculator {

    static {
        System.loadLibrary("fibonacci-jni");
    }

    public long computeFibonacci(long limit) {
        final FibonacciEngineDjinni fibonacciEngineDjinni = FibonacciEngineDjinni.createWithCallback(new FibonacciCallbackDjinni() {
            @Override
            public void reportProgress(String progress) {
                Timber.i(progress);
            }
        });

        return fibonacciEngineDjinni.computeFibonacci(limit);
    }
}
