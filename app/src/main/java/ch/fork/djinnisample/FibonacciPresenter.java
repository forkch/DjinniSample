package ch.fork.djinnisample;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
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


    public void computeFibonacci(final long amount) {
        fibonacciView.clearSequence();
        fibonacciCalculator.computeFibonacci(amount)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
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
