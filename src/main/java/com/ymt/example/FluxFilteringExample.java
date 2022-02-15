package com.ymt.example;

import reactor.core.publisher.Flux;

/**
 *
 * @author yumingtao
 * @date 2022/2/15 13:44
 */
public class FluxFilteringExample {
    public static void main(String[] args) {
        FluxFilteringExample fluxFilteringExample = new FluxFilteringExample();
        fluxFilteringExample.fluxFilter();
        fluxFilteringExample.fluxFirst();
        fluxFilteringExample.fluxLast();
        fluxFilteringExample.fluxSkip();
        fluxFilteringExample.fluxSkipLast();
        fluxFilteringExample.fluxTake();
        fluxFilteringExample.fluxTakeLast();
    }

    public void fluxTakeLast() {
        System.out.println("---fluxTakeLast---");
        Flux.range(1, 5).takeLast(4).subscribe(System.out::println);
    }

    public void fluxTake() {
        System.out.println("---fluxTake---");
        Flux.range(1, 5).take(4).subscribe(System.out::println);
    }

    public void fluxSkipLast() {
        System.out.println("---fluxSkipLast---");
        Flux.range(1, 5).skipLast(3).subscribe(System.out::println);
    }

    public void fluxSkip() {
        System.out.println("---fluxSkip---");
        Flux.range(1, 5).skip(3).subscribe(System.out::println);
    }

    public void fluxLast() {
        System.out.println("---fluxLast---");
        Flux.range(1, 5).last().subscribe(System.out::println);
    }

    public void fluxFirst() {
        System.out.println("---fluxFirst---");
        System.out.println("The first method is not exist.");
    }

    public void fluxFilter() {
        System.out.println("---fluxFilter---");
        Flux.range(1, 5).filter(i -> i % 2 == 0).subscribe(System.out::println);
    }
}
