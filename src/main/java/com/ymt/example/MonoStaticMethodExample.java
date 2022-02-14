package com.ymt.example;

import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @Description
 * @author yumingtao
 * @date 2022-02-14 19:31
 */
public class MonoStaticMethodExample {
    public static void main(String[] args) {
        MonoStaticMethodExample monoStaticMethodExample = new MonoStaticMethodExample();
        monoStaticMethodExample.monoJust();
        monoStaticMethodExample.monoEmpty();
        monoStaticMethodExample.monoJustOrEmpty();
    }

    public void monoJust(){
        System.out.println("---monoJust---");
        Mono.just("yu").subscribe(System.out::println);
    }

    public void monoEmpty(){
        System.out.println("---monoEmpty---");
        Mono.empty().subscribe(System.out::println);
    }

    public void monoJustOrEmpty(){
        System.out.println("---monoJustOrEmpty---");
        Mono.justOrEmpty(Optional.of(1)).subscribe(System.out::println);
        Mono.justOrEmpty(Optional.of(null)).subscribe(System.out::println);
    }
}
