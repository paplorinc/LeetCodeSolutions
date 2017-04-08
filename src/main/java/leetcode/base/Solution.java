package leetcode.base;

/**
 * Given an integer, return its base 7 string representation.
 * 
 * Example 1:
 * 
 * Input: 100
 * Output: "202"
 * 
 * Example 2:
 * 
 * Input: -7
 * Output: "-10"
 * 
 * Note:
 * The input will be in range of [-1e7, 1e7].
 * 
 * Source: https://leetcode.com/problems/base-7/
 */
public class Solution {
    public String convertToBase7(int number) {
        if (number == 0) return "0";
        else {
            boolean isNegative = (number < 0);
            number = Math.abs(number);
            
            StringBuilder result = new StringBuilder();
            for(; number > 0; number /= 7)
                result.append(number % 7);        
            
            if (isNegative) 
                result.append("-");
            return result.reverse().toString();
        }
    }
}
