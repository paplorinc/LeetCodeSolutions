package leetcode.removeDuplicatesfromSortedArray;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 *
 * Source: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        else {
            int start = 0;
            for (int end = 1; end < nums.length; end++)
                if (nums[start] != nums[end])
                    nums[++start] = nums[end];
            return start + 1;
        }
    }
}
