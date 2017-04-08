package leetcode.addStrings;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 
 * Source: https://leetcode.com/problems/add-strings/
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            carry += digitAt(num1, i) + digitAt(num2, i);
            result = result.append(carry % 10);
            carry /= 10;
        }
        if (carry > 0)
            result = result.append(carry);
        return result.reverse().toString();
    }
    
    int digitAt(String num, int reverseIndex) {
        int index = (num.length() - 1) - reverseIndex;
        if (0 <= index && index <= num.length())
            return Character.digit(num.charAt(index), 10);
        else return 0;
    }
}
