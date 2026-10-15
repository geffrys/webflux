package org.geff;

import lombok.extern.java.Log;

import java.util.LinkedList;
import java.util.List;

@Log
public class ReactiveStream<T> {
    private final List<Subscriber> subscribers = new LinkedList<>();

    public ReactiveStream<T> subscribe(Subscriber<T> subscriber) {
        this.subscribers.add(subscriber);
        log.info("[Subscribe] "+subscriber.getName());
        return this;
    }

    public void unsubscribe(Subscriber<T> subscriber) {
        this.subscribers.remove(subscriber);
        log.info("[Unsubscribe] "+subscriber.getName());
    }

    // notifica a todos los subscriptores que hay algo nuevo
    public void emit(T value) {
        this.subscribers.forEach(subscriber -> subscriber.onNext(value));
    }
}
