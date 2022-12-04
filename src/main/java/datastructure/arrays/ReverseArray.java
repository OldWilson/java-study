package datastructure.arrays;

import java.util.Arrays;

/**
 * 给一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class ReverseArray {

    // 临时数组
    public void rotate_001(int[] nums, int k) {
        k = k % nums.length;
        int[] rightpart = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(rightpart, 0, nums, 0, k);
        System.out.println(Arrays.toString(nums));
    }

    // 多次反转
    public void rotate_002(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    // 环形旋转
    public void rotate_003(int[] nums, int k) {
        int hold = nums[0];
        int index = 0;
        int length = nums.length;
        boolean[] visited = new boolean[length];
        for (int i = 0; i < length; i++) {
            index = ( index + k ) % length;
            if (visited[index]) {
                index = ( index + 1 ) % length;
                hold = nums[index];
                i--;
            } else {
                visited[index] = true;
                int temp = nums[index];
                nums[index] = hold;
                hold = temp;
            }
        }
    }
}
