package coding.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort1 implements IImutableSorter{
    @Override
    public List<Integer> sort(List<Integer> A) {
        return quickSort(A);
    }

    private List<Integer> quickSort(List<Integer> A) {
        if (A.size() <= 1) {
            return A;
        }

        var x = A.get(0);
        var left = A.stream().filter(a -> a < x).collect(Collectors.toList());
        var mid = A.stream().filter(a -> a.equals(x)).collect(Collectors.toList());
        var right = A.stream().filter(a -> a > x).collect(Collectors.toList());
        left = quickSort(left);
        right = quickSort(right);
        left.addAll(mid);
        left.addAll(right);
        return left;
    }

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(2, 1, 4, 3);
        QuickSort1 quickSort1 = new QuickSort1();
        System.out.println(quickSort1.sort(list));
    }
}
