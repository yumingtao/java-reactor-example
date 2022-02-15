package com.ymt.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author yumingtao
 * @date 2022/2/15 13:27
 */
public class FluxTransformingExample {
    public static void main(String[] args) {
        FluxTransformingExample fluxTransformingExample = new FluxTransformingExample();
        fluxTransformingExample.fluxBuffer();
        fluxTransformingExample.fluxWindow();
        fluxTransformingExample.fluxMap();
        fluxTransformingExample.fluxFlatMap();
    }

    public void fluxFlatMap(){
        System.out.println("---fluxFlatMap---");
        Flux.just(1, 3).flatMap(x -> Mono.just(x * x)).subscribe(System.out::println);
    }

    public void fluxMap(){
        System.out.println("---fluxMap---");
        Flux.range(1, 3).map(i -> "number:" + i).subscribe(System.out::println);
    }

    public void fluxWindow(){
        System.out.println("---fluxWindow---");
        Flux.range(1, 5).window(3).toIterable().forEach(w ->{
            w.subscribe(System.out::println);
            System.out.println("------");
        });
    }

    public void fluxBuffer() {
        System.out.println("---fluxBuffer---");
        Flux.range(1, 5).buffer(3).subscribe(System.out::println);
    }
}
