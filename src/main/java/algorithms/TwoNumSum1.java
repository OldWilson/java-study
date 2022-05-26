package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumSum1 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get((target - nums[i])), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {-3, 4, 3};
        int target = 0;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
