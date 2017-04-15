package leetcode.singleNumber;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Source: https://leetcode.com/problems/single-number/
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++)
            xor ^= nums[i];
        return xor;
    }
}
