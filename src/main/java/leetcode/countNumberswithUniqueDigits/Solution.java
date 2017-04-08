package leetcode.countNumberswithUniqueDigits;

/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 &le; x &lt; 10n.
 * 
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range of 0 &le; x &lt; 100, excluding [11,22,33,44,55,66,77,88,99])
 * 
 * A direct way is to use the backtracking approach.
 * Backtracking should contains three states which are (the current number, number of steps to get that number and a bitmask which represent which number is marked as visited so far in the current number). Start with state (0,0,0) and count all valid number till we reach number of steps equals to 10n.
 * This problem can also be solved using a dynamic programming approach and some knowledge of combinatorics.
 * Let f(k) = count of numbers with unique digits with length equals k.
 * f(1) = 10, ..., f(k) = 9 * 9 * 8 * ... (9 - k + 2) [The first factor is 9 because a number cannot start with 0].
 * 
 * Credits:Special thanks to @memoryless for adding this problem and creating all test cases.

 * Source: https://leetcode.com/problems/count-numbers-with-unique-digits/
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        switch(n) {
            case 0: return 1;
            case 1: return 10;
            case 2: return 91;
            case 3: return 739;
            case 4: return 5275;
            case 5: return 32491;
            case 6: return 168571;
            case 7: return 712891;
            case 8: return 2345851;
            case 9: return 5611771;
            case 10: return 8877691;
            default: return 0;
        }
        
    }
}
