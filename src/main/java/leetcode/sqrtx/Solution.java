package leetcode.sqrtx;

/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 *
 * Source: https://leetcode.com/problems/sqrtx/
 */
public class Solution {
    public int mySqrt(int n) {
        long root = n;
        while (root * root > n)
            root = (root + n / root) >> 1;
        return (int) root;
    }
}
