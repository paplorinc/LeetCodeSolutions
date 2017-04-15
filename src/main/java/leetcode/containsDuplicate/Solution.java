package leetcode.containsDuplicate;

import java.util.Arrays;

/**
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Source: https://leetcode.com/problems/contains-duplicate/
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++)
            if (nums[i] == nums[i - 1])
                return true;
        return false;
    }
}
