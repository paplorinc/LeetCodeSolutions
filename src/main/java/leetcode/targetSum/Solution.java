package leetcode.targetSum;

import java.util.Arrays;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * Note:
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 *
 * Source: https://leetcode.com/problems/target-sum/
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int sum) {
        int maxSum = Arrays.stream(nums).sum();
        return findTargetSumWays(nums, 0, sum, maxSum);
    }
    public int findTargetSumWays(int[] nums, int start, int sum, int maxSum) {
        if (start >= nums.length) return (sum == 0) ? 1 : 0;
        else if (Math.abs(sum) <= maxSum)
            return findTargetSumWays(nums, start + 1, sum + nums[start], maxSum)
                 + findTargetSumWays(nums, start + 1, sum - nums[start], maxSum);
        else return 0;
    }
}
