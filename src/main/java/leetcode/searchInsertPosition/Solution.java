package leetcode.searchInsertPosition;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 &#8594; 2
 * [1,3,5,6], 2 &#8594; 1
 * [1,3,5,6], 7 &#8594; 4
 * [1,3,5,6], 0 &#8594; 0
 *
 * Source: https://leetcode.com/problems/search-insert-position/
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, 0, nums.length, target);
    }
    public int searchInsert(int[] nums, int start, int end, int target) {
        int mid = start + ((end - start) >> 1);
        if (start >= end || nums[mid] == target) return mid;
        else return (target < nums[mid])
                  ? searchInsert(nums, start, mid, target)
                  : searchInsert(nums, mid + 1, end, target);
    }
}
