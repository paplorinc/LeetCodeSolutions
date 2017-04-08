package leetcode.romantoInteger;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.

 * Source: https://leetcode.com/problems/roman-to-integer/
 */
public class Solution {
    public int romanToInt(String romanDigits) {
        int result = 0;
        for (int next = 0, i = romanDigits.length() - 1; i >= 0; i--) {
            int delta = delta(romanDigits.charAt(i));
            if (next > delta) result -= delta;
            else              result += delta;
            next = delta;
        }
        return result;
    }
    
    int delta(char digit) {
        switch (digit) {
            case 'M': return 1000;
            case 'D': return  500;
            case 'C': return  100;
            case 'L': return   50;
            case 'X': return   10;
            case 'V': return    5;
            case 'I': return    1;
            default: throw new IllegalArgumentException("" + digit);
        }
    }
}
