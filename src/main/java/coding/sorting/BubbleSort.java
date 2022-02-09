package coding.sorting;

import org.junit.Test;

import java.util.Arrays;

public class BubbleSort implements ImutableSorter{
    @Override
    public void sort(int[] A) {
        // 从最左，每次比较两个数，若左大于右则交换，最终将最大的放到最右边
        for (int i = A.length - 1; i >= 0; i--) {
            bubble(A, i);
        }
//        System.out.println(Arrays.toString(A));
    }

    private void bubble(int[] A, int i) {
        for (int k = 0; k < i; k ++) {
            if (A[k] > A[k + 1] ) {
                Helper.swap(A, k, k + 1);
            }
        }
    }

    @Test
    public void test() {
        var arr = new int[]{2, 6, 4, 7, 1};
//        var arr = new int[]{2, 1};
        sort(arr);
    }
}
