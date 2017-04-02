package leetcode.singleNumberIII;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * 
 * 
 * For example:
 * 
 * 
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * 
 * Note:
 * 
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * 
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

 * Source: https://leetcode.com/problems/single-number-iii/
 */
public class Solution {
    // public int[] singleNumber(int[] nums) {
    //     Set<Integer> visited = new HashSet<>();
    //     for (int num : nums)
    //         if (!visited.add(num))
    //             visited.remove(num);
    //     return visited.stream().mapToInt(i -> i).toArray();
    // }
    public int[] singleNumber(int[] nums) {
        int[] results = new int[2];
        int xorBit = Integer.highestOneBit(Arrays.stream(nums).reduce(0, (a, b) -> a ^ b));
        Arrays.stream(nums).forEach(n -> results[((n & xorBit) == 0) ? 0 : 1] ^= n);
        return results;
    }
}
