package leetcode.maximumSubarray;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * click to show more practice.
 * 
 * More practice:
 * 
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * 

 * Source: https://leetcode.com/problems/maximum-subarray/
 */
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public int maxSubArray(int[] nums) {
        AtomicInteger previous = new AtomicInteger(0);
        return Arrays.stream(nums).map(v -> previous.updateAndGet(p -> Math.max(p + v, v))).max().orElse(0);
    }
}