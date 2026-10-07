package org.geff;

public interface Subscriber<T> {

    void onNext(T next);
    String getName();
}
