package coding.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class RandomStringGenerator<T> implements Iterable<T> {

    private final List<T> list;

    public RandomStringGenerator(List<T> list) {
        this.list = list;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public T next() {
                return list.get((int) (list.size() * Math.random()));
            }
        };
    }

    public static void main(String[] args) {
        var list = Arrays.asList("aaa", "bbb", "ccc");
//        System.out.println((int) (list.size() * Math.random()));
        var gen = new RandomStringGenerator<>(list);

//        var it = gen.iterator();
//        for (int i = 0; i < 100; i++) {
//            System.out.println(it.next());
//        }

        System.out.println(Arrays.toString(list.toArray(String[]::new)));
    }
}
