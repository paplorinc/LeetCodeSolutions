package leetcode.kthLargestElementinanArray;

import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * 
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 * Credits:Special thanks to @mithmatt for adding this problem and creating all test cases.

 * Source: https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++)
            maxQueue.add(nums[i]);

        for (int i = k; i < nums.length; i++) {
            maxQueue.add(nums[i]);
            maxQueue.poll();
        }
        return maxQueue.peek();
    }
}
