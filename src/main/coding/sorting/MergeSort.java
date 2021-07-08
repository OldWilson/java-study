package coding.sorting;

import org.junit.Test;

import java.util.Arrays;

public class MergeSort implements ImutableSorter{

    @Override
    public void sort(int[] A) {
        // 每次将数组拆分为两份，每份N/2，两份各自排好序，然后合并
        mergeSort(A, 0, A.length);
//        System.out.println(Arrays.toString(A));
    }

    private void mergeSort(int[] A, int l, int r) {
        if (r - l <= 1){
//        if (l >= r){
            return;
        }

        int mid = (l + r + 1) / 2;
        mergeSort(A, l, mid);
        mergeSort(A, mid, r);

        merge(A, l, mid, r);
    }

    private void merge(int[] A, int l, int mid, int r) {
        int[] B = Arrays.copyOfRange(A, l, mid + 1);
        int[] C = Arrays.copyOfRange(A, mid, r + 1);

        B[B.length - 1] = C[C.length - 1] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = l; k < r; k++) {
            if (B[i] < C[j]) {
                A[k] = B[i++];
            } else {
                A[k] = C[j++];
            }
        }
    }

    @Test
    public void test() {
        int[] arr = new int[]{2, 1,4,3};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
    }
}
