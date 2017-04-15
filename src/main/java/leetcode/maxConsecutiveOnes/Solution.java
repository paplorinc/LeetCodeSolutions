package leetcode.maxConsecutiveOnes;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *     The maximum number of consecutive 1s is 3.
 * Note:
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 *
 * Source: https://leetcode.com/problems/max-consecutive-ones/
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, localMax = 0;
        for (int num : nums) {
            if (num == 1) {
                localMax++;
                max = Math.max(max, localMax);
            } else {
                localMax = 0;
            }
        }
        return max;
    }
}
