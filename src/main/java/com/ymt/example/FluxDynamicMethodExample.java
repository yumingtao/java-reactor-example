package com.ymt.example;

import reactor.core.publisher.Flux;

/**
 *
 * @author yumingtao
 * @date 2022/2/14 17:26
 */
public class FluxDynamicMethodExample {
    public static void main(String[] args) {
        FluxDynamicMethodExample fluxDynamicMethodExample = new FluxDynamicMethodExample();
        fluxDynamicMethodExample.fluxGenerate();
        fluxDynamicMethodExample.fluxCreate();
    }

    public void fluxGenerate() {
        System.out.println("---fluxGenerate---");
        Flux.generate(sink -> {
            sink.next("yumingtao");
            sink.complete();
        }).subscribe(System.out::println);

        Flux.generate(() -> 1, (i, sink) -> {
            sink.next(i);
            if (i == 5) {
                sink.complete();
            }
            return ++i;
        }).subscribe(System.out::println);
    }

    public void fluxCreate() {
        System.out.println("---fluxCreate---");
        Flux.create(sink -> {
            for (int i = 0; i < 5; i++) {
                sink.next(i);
            }
            sink.complete();
        }).subscribe(System.out::println);
    }
}
