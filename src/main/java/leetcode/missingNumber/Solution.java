package leetcode.missingNumber;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * 
 * 
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * 
 * 
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

 * Source: https://leetcode.com/problems/missing-number/
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int expectedSum = nums.length * (nums.length + 1) >> 1;
        return expectedSum - sum;
    }
}
