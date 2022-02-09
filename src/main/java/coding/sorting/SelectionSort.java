package coding.sorting;

import org.junit.Test;

import java.util.Arrays;

public class SelectionSort implements ImutableSorter{
    @Override
    public void sort(int[] A) {
        // 选择最大的放到最右边
        for (int i = A.length - 1; i >= 0; i--) {
            int j = maxIndex(A, i);
            if (i != j) {
                Helper.swap(A, i, j);
            }
        }
//        System.out.println(Arrays.toString(A));
    }

    private int maxIndex(int[] A, int j) {
        int max = Integer.MIN_VALUE;
        int maxIndex = j;
        for (int k = j; k >= 0; k--) {
            if (max < A[k]) {
                max = A[k];
                maxIndex = k;
            }
        }
        return maxIndex;
    }

    @Test
    public void test() {
//        var arr = new int[]{2, 6, 4, 7, 1};
        var arr = new int[]{2, 1};
        sort(arr);
    }
}
