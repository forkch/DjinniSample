package ch.fork.djinnisample;

import rx.android.schedulers.AndroidSchedulers;
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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(longs -> longs)
                .subscribe(sequenceChunk -> {
                            Timber.i("received new chunk: " + sequenceChunk.toString());
                            fibonacciView.nextChunkComputed(sequenceChunk);
                        }
                );
    }
}
