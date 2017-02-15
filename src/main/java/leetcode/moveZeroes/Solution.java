package leetcode.moveZeroes;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * 
 * 
 * 
 * For example, given nums  = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * 
 * 
 * 
 * Note:
 * 
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

 * Source: https://leetcode.com/problems/move-zeroes/
 */
public class Solution {
    public void moveZeroes(int... nums) {
        int zero = 0, nonZero = 0;
        while (true) {
            while (zero < nums.length && nums[zero] != 0) zero++;
            
            nonZero = zero + 1;
            while (nonZero < nums.length && nums[nonZero] == 0) nonZero++;
            
            if (zero < nums.length && nonZero < nums.length) {
                swap(nums, zero, nonZero);
            } else return;
        }
    }
    
    void swap(int[] nums, int i, int j) {
        int copy = nums[i];
        nums[i] = nums[j];
        nums[j] = copy;
    }
}
