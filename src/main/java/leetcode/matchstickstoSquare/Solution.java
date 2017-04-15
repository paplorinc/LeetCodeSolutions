package leetcode.matchstickstoSquare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
 *  Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
 * Example 1:
 * Input: [1,1,2,2,2]
 * Output: true
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 * Example 2:
 * Input: [3,3,3,3,4]
 * Output: false
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 * Note:
 * The length sum of the given matchsticks is in the range of 0 to 10^9.
 * The length of the given matchstick array will not exceed 15.
 *
 * Source: https://leetcode.com/problems/matchsticks-to-square/
 */
public class Solution {
    public boolean makesquare(int... nums) {
        long sum = Arrays.stream(nums).sum();
        if ((sum == 0) || (sum & 3) > 0) return false;
        else {
            nums = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
            long side = sum >>> 2;
            return (nums[0] <= side) && canMakeSquare(nums, 0, side, side, side, side);
        }
    }
    boolean canMakeSquare(int[] nums, int index, long sum1, long sum2, long sum3, long sum4) {
        if (index >= nums.length) return (sum1 | sum2 | sum3 | sum4) == 0;
        else return ((sum1 >= nums[index]) && canMakeSquare(nums, index + 1, sum1 - nums[index], sum2, sum3, sum4))
                 || ((sum2 >= nums[index]) && canMakeSquare(nums, index + 1, sum1, sum2 - nums[index], sum3, sum4))
                 || ((sum3 >= nums[index]) && canMakeSquare(nums, index + 1, sum1, sum2, sum3 - nums[index], sum4))
                 || ((sum4 >= nums[index]) && canMakeSquare(nums, index + 1, sum1, sum2, sum3, sum4 - nums[index]));
    }
}
