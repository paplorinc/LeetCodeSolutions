package leetcode.factorialTrailingZeroes;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * Credits:Special thanks to @ts for adding this problem and creating all test cases.

 * Source: https://leetcode.com/problems/factorial-trailing-zeroes/
 */
public class Solution {
    public int trailingZeroes(int n) {
        int ans=0;
        while (n>=5) {
            n/=5;
            ans+=n;
        }
        return ans;
    }
}
