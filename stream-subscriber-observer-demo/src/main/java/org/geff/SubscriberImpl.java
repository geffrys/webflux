package org.geff;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Stream;

@Log // log por defecto que tiene java.
@AllArgsConstructor
public class SubscriberImpl<T> implements Subscriber<T> {

    // interfaz generica, cuyo metodo por defecto es apply
    private final Function<T, String> mapper;
    private final String name;
    @Override
    public void onNext(T next) {
        final var valueMapped = this.mapper.apply(next);
        log.info("[onNext] "+next);
        log.info("[onNext] mapped: "+valueMapped);

    }

    @Override
    public String getName() {
        return "";
    }
}
