package coding.sorting;

public class QuickSort implements ImutableSorter{
    @Override
    public void sort(int[] A) {
        // 选择最左边到元素构造子问题集合
        // 小于x的放到左边，大于x的放到右边
        quickSort(A, 0, A.length);
    }

    private void quickSort(int[] A, int l, int r) {
        if (r - l <= 1) {
            return;
        }

        int i = partition(A, l, r);
        quickSort(A, l, i);
        quickSort(A, i + 1, r);
    }

    private int partition(int[] A, int l, int r) {
        int x = A[l];

        int i = l + 1;
        int j = r;
        while (i != j) {
            if (A[i] < x) {
                i++;
            } else {
                Helper.swap(A, i, --j);
            }
        }
        Helper.swap(A, i - 1, l);
        return i - 1;
    }
}
