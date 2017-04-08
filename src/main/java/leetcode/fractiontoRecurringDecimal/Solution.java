package leetcode.fractiontoRecurringDecimal;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * 
 * For example,
 * 
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * 
 * No scary math, just apply elementary math knowledge. Still remember how to perform a long division?
 * Try a long division on 4/9, the repeating part is obvious. Now try 4/333. Do you see a pattern?
 * Be wary of edge cases! List out as many test cases as you can think of and test your code thoroughly.
 * 
 * Credits:Special thanks to @Shangrila for adding this problem and creating all test cases.

 * Source: https://leetcode.com/problems/fraction-to-recurring-decimal/
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        String sign = (Math.signum(numerator) * Math.signum(denominator) < 0) ? "-" : "";
        long num = Math.abs((long) numerator), den = Math.abs((long) denominator);
        return sign + (num / den) + fraction(num % den, den);
    } 
    private static String fraction(long numerator, long denominator) {
        if (numerator == 0) return "";
        else {
            StringBuilder result = new StringBuilder(".");
            Map<Long, Integer> remainders = new HashMap<>();
            for (int i = result.length(); remainders.putIfAbsent(numerator % denominator, i) == null; i++) {
                numerator *= 10;
                result.append(numerator / denominator);
                numerator %= denominator;
            }
            if (remainders.containsKey(0L)) return result.substring(0, result.length() - 1);
            else return result.insert(remainders.get(numerator % denominator), "(") + ")";
        }
    }
}
