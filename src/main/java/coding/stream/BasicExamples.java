package coding.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicExamples {

    @Test
    public void tst_mapFilter() {
        Stream.of(1,2,3,4,5,6)
                .map(Object::toString)
                .map(Integer::parseInt)
                .forEach(System.out::println);
    }

    @Test
    public void test_mapfilterreduce() {
//        var result = Stream.of(1,2,3,4,5,6)
        var result = IntStream.of()
                .map(x -> x * x)
                .filter(x -> x < 20)
                .reduce(Math::max);
        result.ifPresent(System.out::println);
        System.out.println(result.orElse(0));
    }

    @Test
    public void test_mutation() {
        var stream = Stream.of(1,3,5,2,5,3,6,7,3).sorted();
        stream.forEach(System.out::println);
    }

    @Test
    public void test_flatMap() {
        // String -> Stream<R>
        Stream.of("My", "Mine")
                .flatMap(str -> str.chars().mapToObj(i -> (char)i))
                .collect(Collectors.toSet())
                .forEach(System.out::print);
//        System.out.println(new ArrayList<>(set));
    }

    @Test
    public void test_parallel() throws ExecutionException, InterruptedException {
        var r = new Random();
        var list = IntStream.range(0, 1_000_000)
                .map(x -> r.nextInt(10_000_000))
                .boxed()
                .collect(Collectors.toList());
//        System.out.println(list);

        var t0 = System.currentTimeMillis();
        System.out.println(list.stream().max(Comparator.comparingInt(x -> x)));
        System.out.println("time1: " + (System.currentTimeMillis() - t0));

        var t1 = System.currentTimeMillis();
        System.out.println(list.stream().parallel().max(Comparator.comparingInt(a -> a)));
        System.out.println("time2: " + (System.currentTimeMillis() - t1));

        var t3 = System.currentTimeMillis();
        var pool = new ForkJoinPool(2);
        System.out.println(pool.submit(() -> list.stream().parallel().max(Comparator.comparingInt(a -> a))).get());
        System.out.println("time3: " + (System.currentTimeMillis() - t3));
    }

}
