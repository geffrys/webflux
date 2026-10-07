package org.geff;


import lombok.extern.java.Log;

@Log
public class Main {
    static void main() {
        // Publishers
        final ReactiveStream<String> stringStream = new ReactiveStream<>(); // publisher.
        final ReactiveStream<Integer> integerReactiveStream = new ReactiveStream<>();

        // Subscribers Name
        final String subsName1 = "Subscriber1";
        final String subsName2 = "Subscriber2";
        final String subsName3 = "Subscriber3";
        final String subsName4 = "Subscriber4";

        // Subscribers
        final Subscriber<String> strSubscriber1 = new SubscriberImpl<>(
                str -> "Length: "+str.length(),
                subsName1
        );
        final Subscriber<String> strSubscriber2 = new SubscriberImpl<>(
                String::toUpperCase,
                subsName2
        );
        final Subscriber<Integer> strSubscriber3 = new SubscriberImpl<>(
                num -> "Value:" + num,
                subsName3
        );
        final Subscriber<Integer> strSubscriber4 = new SubscriberImpl<>(
                num -> "square:" + (num*num),
                subsName4
        );

        log.info("[Subscriptions]");
        // Subscriptions
        log.info("[Strings]");
        stringStream
                .subscribe(strSubscriber1)
                .subscribe(strSubscriber2);
        log.info("[Integers]");
        integerReactiveStream
                .subscribe(strSubscriber3)
                .subscribe(strSubscriber4);

        stringStream.emit("Hello world");
        stringStream.emit("Colombia");
        stringStream.emit("Bogota");

        integerReactiveStream.emit(5);
        integerReactiveStream.emit(10);

        log.info("[Unsusbcriptions]");

    }
}
