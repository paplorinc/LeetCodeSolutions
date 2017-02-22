package leetcode.removeElement;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * 
 * 
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * 
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * 
 * 
 * Your function should return length = 2, with the first two elements of nums being 2.
 * 
 * 
 * Try two pointers.
 * Did you use the property of "the order of elements can be changed"?
 * What happens when the elements to remove are rare?
 * 

 * Source: https://leetcode.com/problems/remove-element/
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int start = 0;
        for (int end = nums.length - 1; start <= end; ) {
            boolean startsWithVal = (nums[start] == val);
            boolean endsWithVal = (nums[end] == val);
            if (startsWithVal && !endsWithVal) swap(nums, start++, end--);
            else {
                if (!startsWithVal) start++;
                if (endsWithVal) end--;
            }
        }
        return start;
    }
    void swap(int[] nums, int i, int j){
        int copy = nums[i];
        nums[i] = nums[j];
        nums[j] = copy;
    }
}
