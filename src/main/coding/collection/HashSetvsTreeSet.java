package coding.collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class HashSetvsTreeSet {

    @Test
    public void test_order() {
        var hashSet = new HashSet<Integer>();
        hashSet.add(3);
        hashSet.add(7);
        hashSet.add(2);
        hashSet.add(10);
        System.out.println(hashSet.stream().map(x -> x.toString()).collect(Collectors.joining(",")));

        var treeSet = new TreeSet<Integer>() {
            {
                add(3);
                add(7);
                add(2);
                add(10);
            }
        };
        System.out.println(treeSet.stream().map(x -> x.toString()).collect(Collectors.joining(",")));
    }

    @Test
    public void test() {
        var random = new Random(10);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(random.nextInt(10));
//        }
        random.ints(97, 123).limit(1).forEach(System.out::println);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.appendCodePoint(97);
//        stringBuilder.append(97);
        System.out.println(stringBuilder);
//        System.out.println(random.ints(97, 123).limit(1).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
    }

    @Test
    public void test_benchmark() {
        var random = new Random();
        LinkedList<String> words = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            var word = random.ints(97, 123)
                    .limit(12)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            words.add(word);
        }

        var hashSet = new HashSet<String>();
        var treeSet = new TreeSet<String>();

        var start = System.currentTimeMillis();
        for (var w : words) {
            hashSet.add(w);
        }
        for (var w : words) {
            hashSet.contains(w);
        }
        System.out.println("hashSet time: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (var w : words) {
            treeSet.add(w);
        }

        for (var w : words) {
            treeSet.contains(w);
        }
        System.out.println("treeSet time: " + (System.currentTimeMillis() - start));
    }
}
