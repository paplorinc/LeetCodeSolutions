package leetcode.findAllNumbersDisappearedinanArray;

import java.util.ArrayList;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * 
 * Example:
 * 
 * Input:
 * [4,3,2,7,8,2,3,1]
 * 
 * Output:
 * [5,6]
 * 
 * Source: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class Solution {
    public java.util.List<Integer> findDisappearedNumbers(int[] nums) {
        java.util.BitSet expected = new java.util.BitSet(nums.length);
        for (int num : nums)
            expected.set(num - 1);

        java.util.List<Integer> result = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!expected.get(i))
                result.add(i + 1);
        }

        return result;
    }
}

// [1,2,3,4,5,6,7,8]
// [1,2,2,3,3,4,7,8]
// [4,3,2,7,8,2,3,1]
