package com.ymt.example;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yumingtao
 * @date 2022/2/14 13:45
 */
public class FluxStaticMethodExample {
    public static void main(String[] args) throws InterruptedException {
        FluxStaticMethodExample fluxStaticMethodExample = new FluxStaticMethodExample();
        fluxStaticMethodExample.fluxJust();
        fluxStaticMethodExample.fluxFromArray();
        fluxStaticMethodExample.fluxFromStream();
        fluxStaticMethodExample.fluxFromIterable();
        fluxStaticMethodExample.fluxRange();
        fluxStaticMethodExample.fluxInterval();
        fluxStaticMethodExample.fluxEmpty();
        fluxStaticMethodExample.fluxError();
        fluxStaticMethodExample.fluxNever();
    }

    public void fluxNever() throws InterruptedException {
        System.out.println("---fluxNever---");
        Flux.never().subscribe(System.out::println);
        Thread.sleep(200);
        System.out.println("---fluxNever end---");
    }

    public void fluxError() throws InterruptedException {
        System.out.println("---fluxError---");
        Flux.error(new Throwable()).subscribe(System.out::println);
        TimeUnit.MICROSECONDS.sleep(200);
        System.out.println("---fluxError end---");
    }

    public void fluxEmpty() {
        System.out.println("---fluxEmpty---");
        Flux.empty().subscribe(System.out::println);
        Flux.error(new Throwable()).subscribe(System.out::println);
    }

    public void fluxInterval() throws InterruptedException {
        System.out.println("---fluxInterval---");
        Flux.interval(Duration.ofSeconds(2), Duration.ofMillis(200)).subscribe(System.out::println);
        TimeUnit.SECONDS.sleep(3);
        //Thread.yield(); //让出cpu，不能达到效果
        System.out.println("---fluxInterval end---");
    }

    public void fluxRange() {
        System.out.println("---fluxRange---");
        Flux.range(8, 3).subscribe(System.out::println);
    }

    public void fluxFromIterable() {
        System.out.println("---fluxIterable---");
        List<Integer> list = Arrays.asList(new Integer[]{15, 16, 17, 18});
        Flux.fromIterable(list).subscribe(System.out::println);
    }

    public void fluxFromStream() {
        System.out.println("---fluxStream---");
        List<Integer> list = Arrays.asList(new Integer[]{5, 6, 7, 8});
        Flux.fromStream(list.stream()).subscribe(System.out::println);
    }

    public void fluxFromArray() {
        System.out.println("---fluxFromArray---");
        Flux.fromArray(new Integer[]{2, 3, 4}).subscribe(System.out::println);
    }

    public void fluxJust() {
        System.out.println("---fluxJust---");
        Flux.just("hello", "world").subscribe(System.out::println);
    }
}
