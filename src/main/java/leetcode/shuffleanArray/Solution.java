package leetcode.shuffleanArray;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Shuffle a set of numbers without duplicates.
 * <p>
 * Example:
 * <p>
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * <p>
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * <p>
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 * <p>
 * Source: https://leetcode.com/problems/shuffle-an-array/
 */
public class Solution {
    int[] copy, nums;
    
    public Solution(int[] nums) {
        this.nums = nums;
        this.copy = nums.clone();
    }
    
    public int[] reset() {
        nums = copy.clone();
        return nums;
    }
    
    public int[] shuffle() {
        for (int i = nums.length - 1; i > 0; i--)
            swap(nums, i, ThreadLocalRandom.current().nextInt(i + 1));
        return nums;
    }
    private static void swap(int[] nums, int i, int j) {
        int copy = nums[i];
        nums[i] = nums[j];
        nums[j] = copy;
    }
}
