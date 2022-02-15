package com.ymt.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * Description
 *
 * @author yumingtao
 * @date 2022/2/15 14:37
 */
public class FluxCombiningExample {
    public static void main(String[] args) {
        FluxCombiningExample fluxCombiningExample = new FluxCombiningExample();
        fluxCombiningExample.fluxThen();
        fluxCombiningExample.fluxWhen();
        fluxCombiningExample.fluxMerge();
        fluxCombiningExample.fluxMergeSequential();
        fluxCombiningExample.fluxZip();
        fluxCombiningExample.fluxZipWith();
        fluxCombiningExample.fluxZipWithBiFunction();
    }

    public void fluxZipWithBiFunction() {
        System.out.println("---fluxZipWithBiFunction---");
        Flux<Integer> flux1 = Flux.just(11, 12);
        Flux<Integer> flux2 = Flux.just(13, 14);
        flux1.zipWith(flux2, (s1, s2) -> String.format("%s+%s=%s", s1, s2, s1 + s2)).subscribe(System.out::println);
    }

    public void fluxZipWith() {
        System.out.println("---fluxZipWith---");
        Flux flux1 = Flux.just(11, 12);
        Flux flux2 = Flux.just(13, 14);
        flux1.zipWith(flux2).subscribe(System.out::println);
    }

    public void fluxZip() {
        System.out.println("---fluxZip---");
        Flux flux1 = Flux.just(1, 2);
        Flux flux2 = Flux.just(3, 4);
        Flux.zip(flux1, flux2).subscribe(System.out::println);
    }

    public void fluxMergeSequential() {
        System.out.println("---fluxMergeSequential---");
        Flux.mergeSequential(Flux.interval(Duration.ofMillis(0), Duration.ofMillis(100)).take(2),
                        Flux.interval(Duration.ofMillis(50), Duration.ofMillis(100)).take(3))
                .toStream().forEach(System.out::println);
    }

    public void fluxMerge() {
        System.out.println("---fluxMerge---");
        Flux.merge(Flux.interval(Duration.ofMillis(0), Duration.ofMillis(100)).take(2),
                        Flux.interval(Duration.ofMillis(50), Duration.ofMillis(100)).take(3))
                .toStream().forEach(System.out::println);
    }

    public void fluxWhen() {
        System.out.println("---fluxWhen---");
        long start = System.currentTimeMillis();
        Flux.just(8).flatMap(x -> {
            Mono<Integer> res1 = null;
            Mono<Integer> res2 = null;
            try {
                res1 = process1(x);
                res2 = process2(x);
            } catch (InterruptedException e) {
                System.out.println("Error:" + e.getMessage());
            }
            return Mono.when(res1, res2);
        }).subscribe();
        System.out.printf("Take %d milliseconds\n", System.currentTimeMillis() - start);
        System.out.println("---fluxWhen end---");
    }

    private Mono<Integer> process1(int x) throws InterruptedException {
        System.out.println("process1 start...");
        int res = x * x;
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println("process1 end.");
        return Mono.just(res);
    }

    private Mono<Integer> process2(int x) throws InterruptedException {
        System.out.println("process2 start...");
        int res = 2 * x;
        TimeUnit.MILLISECONDS.sleep(400);
        System.out.println("process2 end.");
        return Mono.just(res);
    }

    public void fluxThen() {
        System.out.println("---fluxThen---");
        Flux.range(1, 5).then().subscribe(System.out::println);
        Flux.range(1, 5).thenMany(Flux.just(6, 7)).subscribe(System.out::println);
    }
}
