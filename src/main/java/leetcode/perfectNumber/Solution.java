package leetcode.perfectNumber;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 * 
 * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 * 
 * 
 * Example:
 * 
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * 
 * 
 * 
 * Note:
 * The input number n will not exceed 100,000,000. (1e8)
 * 

 * Source: https://leetcode.com/problems/perfect-number/
 */
public class Solution {
    public boolean checkPerfectNumber(int num) {
        return (num >= 6) && (num == IntStream.rangeClosed(2, (int) Math.sqrt(num)).filter(i -> num % i == 0).flatMap(i -> IntStream.of(i, num / i)).sum() + 1);
    }
}