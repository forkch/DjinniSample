package ch.fork.djinnisample;

import java.util.List;

/**
 * Created by fork on 04.08.15.
 */
public interface FibonacciView {
    void nextChunkComputed(List<Long> sequenceChunk);

    void clearSequence();
}
