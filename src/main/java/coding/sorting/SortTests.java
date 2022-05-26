//package coding.sorting;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.lang.reflect.InvocationTargetException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class SortTests {
//
//    @Test
//    public void test_insertionSort() {
//        sortTest(InsertionSort.class, 100_000); // 976
//    }
//
//    @Test
//    public void test_selectionSort() {
//        sortTest(SelectionSort.class, 100_000); // 1684
//    }
//
//    @Test
//    public void test_bubbleSort() {
//        sortTest(BubbleSort.class, 100_000); // 12096
//    }
//
//    @Test
//    public void test_mergeSort() {
//        sortTest(MergeSort.class, 100_000); // 44
//    }
//
//    @Test
//    public void test_quickSort() {
//        sortTest(QuickSort.class, 100_000); // 54
//    }
//
//    @Test
//    public void test_quickSort1() {
//        sortTest(QuickSort1.class, 100_000); // 207
//    }
//
//    @Test
//    public void test_bucketSort() {
//        var bucketSort = new BucketSort();
//        ArrayList<Integer> l = new ArrayList<>();
//        for (int i = 0; i < 100_000; i++) {
//            l.add((int) (Math.random() * 100));
//        }
//        var start = System.currentTimeMillis();
//        List<Integer> A = bucketSort.sort(l);
//        System.out.println("time usage: " + (System.currentTimeMillis() - start)); // 24
//        assertSorted(A);
//    }
//
//    @Test
//    public void test() {
////        System.out.println((int) (Math.random() * 100));
//        System.out.println(2 >> 8);
//    }
//
//    public void sortTest(Class cls, int N) {
//        try {
//            var constructor = cls.getConstructor();
//            var rawInst = constructor.newInstance();
//            var start = System.currentTimeMillis();
//            if (rawInst instanceof ImutableSorter inst) {
//                var A = gen(N).stream().mapToInt(x -> x).toArray();
//                inst.sort(A);
//                System.out.println("time usage: " + (System.currentTimeMillis() - start));
//                assertSorted(A);
//            } else if (rawInst instanceof IImutableSorter inst) {
//                var A = gen(N);
//                A = inst.sort(A);
//                System.out.println("time usage: " + (System.currentTimeMillis() - start));
//                assertSorted(A);
//            }
//        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    static void assertSorted(int[] A) {
//        assertSorted(Arrays.stream(A).boxed().collect(Collectors.toList()));
//    }
//
//    static void assertSorted(List<Integer> A) {
//        int o = Integer.MIN_VALUE;
//        for (var i : A) {
//            if (o > i) {
//                System.out.println(A);
//                Assert.fail("Array not in sorted order");
//            }
//            o = i;
//        }
//    }
//
//    static List<Integer> gen(int n) {
//        var A = new ArrayList<Integer>();
//        for (int i = 0; i < n; i++) {
//            A.add((int) (Math.random() * n));
//        }
//        return A;
//    }
//}
