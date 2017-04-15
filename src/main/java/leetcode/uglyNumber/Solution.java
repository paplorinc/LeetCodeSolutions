package leetcode.uglyNumber;

/**
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * Note that 1 is typically treated as an ugly number.
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 *
 * Source: https://leetcode.com/problems/ugly-number/
 */
public class Solution {
    public boolean isUgly(int num) {
        for (int divisor : new int[]{2, 3, 5})
            while (num > 0 && num % divisor == 0)
                num /= divisor;
        return num == 1;
    }
}
