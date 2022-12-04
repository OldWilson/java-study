package test;

import java.util.Arrays;

public class demoTest {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = { 1, 2, 3, 4, 5};
        int[] rightpart = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(rightpart, 0, nums, 0, k);
        System.out.println(Arrays.toString(nums));
    }
}
