package ch.fork.djinnisample;

import java.sql.Time;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by fork on 04.08.15.
 */
public class FibonacciPresenter {


    private final FibonacciCalculator fibonacciCalculator;
    private FibonacciView fibonacciView;

    public FibonacciPresenter(FibonacciView fibonacciView) {
        this.fibonacciView = fibonacciView;
        fibonacciCalculator = new FibonacciCalculator();
    }


    public void computeFibonacci(int amount) {
        fibonacciView.clearSequence();
        fibonacciCalculator.computeFibonacci(amount)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<List<Long>, List<Long>>() {
                    @Override
                    public List<Long> call(List<Long> longs) {
                        return longs;
                    }
                })
                .subscribe(new Action1<List<Long>>() {
                               @Override
                               public void call(List<Long> sequenceChunk) {
                                   Timber.i("received new chunk: " + sequenceChunk.toString());
                                   fibonacciView.nextChunkComputed(sequenceChunk);
                               }
                           }
                );
    }
}
