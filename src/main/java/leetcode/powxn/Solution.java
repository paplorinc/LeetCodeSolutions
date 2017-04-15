package leetcode.powxn;

/**
 * Implement pow(x, n).
 *
 * Source: https://leetcode.com/problems/powx-n/
 */
public class Solution {
    public double myPow(double x, long n) {
        if (n < 0) return myPow(1 / x, -n);
        else if (x == 1 || n == 0) return 1;
        else if (n == 1) return x;
        else return (((n & 1) == 0) ? 1 : x) * myPow(x * x, n >> 1);
    }
}
