package coding.sorting;

public class InsertionSort implements ImutableSorter {
    @Override
    public void sort(int[] A) {
        // 拿到一张牌，与当前手牌比较，比手牌大则交换
        for (int i = 1;i < A.length; i++) {
            int c = A[i];
            int j = i;
            for (;j > 0 && A[j - 1] > c; j--) {
                A[j] = A[j - 1];
            }
            A[j] = c;
        }
    }
}
