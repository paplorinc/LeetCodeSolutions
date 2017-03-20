package leetcode.productofArrayExceptSelf;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

 * Source: https://leetcode.com/problems/product-of-array-except-self/
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];
        for (int product = 1, i = 0; i < nums.length; product *= nums[i++])
            results[i] = product;
        for (int product = 1, i = nums.length - 1; i >= 0; product *= nums[i--])
            results[i] *= product;
        return results;
    }
}
