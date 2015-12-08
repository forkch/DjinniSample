package ch.fork.djinnisample;

import java.util.ArrayList;
import java.util.List;

import ch.fork.djinnisample.FibonacciCallbackDjinni;
import ch.fork.djinnisample.FibonacciEngineDjinni;
import rx.Observable;
import rx.Subscriber;

/**
 * Created with love by fork on 28.07.15.
 */
public class FibonacciCalculator {

    static {
        System.loadLibrary("fibonacci-jni");
    }

    public Observable<List<Long>> computeFibonacci(final long amount) {

        Observable<List<Long>> myObservable = Observable.create(
                new Observable.OnSubscribe<List<Long>>() {
                    @Override
                    public void call(final Subscriber<? super List<Long>> sub) {

                        final FibonacciEngineDjinni fibonacciEngineDjinni = FibonacciEngineDjinni.createWithCallback(new FibonacciCallbackDjinni() {
                            @Override
                            public void reportProgress(ArrayList<Long> fibonacciSequenceChunk) {
                                sub.onNext(fibonacciSequenceChunk);
                            }

                        });
                        fibonacciEngineDjinni.computeFibonacci(amount);
                    }
                }
        );
        return myObservable;
    }

}
