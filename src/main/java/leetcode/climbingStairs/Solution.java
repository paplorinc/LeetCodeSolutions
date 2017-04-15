package leetcode.climbingStairs;

import java.util.HashMap;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 *
 * Source: https://leetcode.com/problems/climbing-stairs/
 */
public class Solution {
    public int climbStairs(int n) {
        return memoized(n, new HashMap<>());
    }
    int memoized(int n, java.util.Map<Integer, Integer> visited) {
        return visited.compute(n, (k, v) -> (v != null) ? v : climbStairs(n, visited));
    }
    int climbStairs(int n, java.util.Map<Integer, Integer> visited) {
        if (n < 0) return 0;
        else if (n == 0) return 1;
        else return memoized(n - 1, visited) + memoized(n - 2, visited);
    }
}
