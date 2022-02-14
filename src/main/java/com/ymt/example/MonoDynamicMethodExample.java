package com.ymt.example;

import reactor.core.publisher.Mono;

/**
 * @Description
 * @author yumingtao
 * @date 2022-02-14 20:04
 */
public class MonoDynamicMethodExample {
    public static void main(String[] args) {
        MonoDynamicMethodExample monoDynamicMethodExample = new MonoDynamicMethodExample();
        monoDynamicMethodExample.monoCreate();
    }

    public void monoCreate() {
        System.out.println("---monoCreate---");
        Mono.create(monoSink ->
                monoSink.success("yumingtao")).subscribe(System.out::println);
    }
}
