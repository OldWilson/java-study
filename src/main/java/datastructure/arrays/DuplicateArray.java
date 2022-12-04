package datastructure.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 去重
 */
public class DuplicateArray {


    // 现排序，后判断
    public boolean containsDuplicate_001(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Set集合去重，判断size
    public boolean containsDuplicate_002(int[] nums) {
        Set<Integer> numSet = (Set<Integer>) Set.of(nums);
        return nums.length == numSet.size();
    }
}
