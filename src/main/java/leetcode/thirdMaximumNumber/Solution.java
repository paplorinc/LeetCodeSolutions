package leetcode.thirdMaximumNumber;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 * 
 * Example 1:
 * 
 * Input: [3, 2, 1]
 * 
 * Output: 1
 * 
 * Explanation: The third maximum is 1.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [1, 2]
 * 
 * Output: 2
 * 
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: [2, 2, 3, 1]
 * 
 * Output: 1
 * 
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 * 
 * 

 * Source: https://leetcode.com/problems/third-maximum-number/
 */
public class Solution {
    private static final int size = 3;
    public int thirdMax(int[] nums) {
        TreeSet<Integer> maxes = new TreeSet<>();
        for (int num : nums) {
            maxes.add(num);
            if (maxes.size() > size)
                maxes.pollFirst();
        }
        if (maxes.size() == size) return maxes.pollFirst();
        else return maxes.pollLast();
    }
}
