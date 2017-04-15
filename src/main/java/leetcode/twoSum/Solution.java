package leetcode.twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * Source: https://leetcode.com/problems/two-sum/
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer complementIndex = indices.get(target - nums[i]);
            if (complementIndex != null) return new int[]{complementIndex, i};
            else indices.put(nums[i], i);
        }
        return null;
    }
}
