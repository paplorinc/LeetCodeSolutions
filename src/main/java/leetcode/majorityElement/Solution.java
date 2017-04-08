package leetcode.majorityElement;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than &lfloor; n/2 &rfloor; times.
 * 
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * Credits:Special thanks to @ts for adding this problem and creating all test cases.

 * Source: https://leetcode.com/problems/majority-element/
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0], count = 0;
        for (int num : nums) {
            if (num == majority) count++;
            else if (--count < 0) {
                majority = num;
                count = 0;
            }
        }
        return majority;
    }
}
