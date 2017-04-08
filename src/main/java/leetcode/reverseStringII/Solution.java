package leetcode.reverseStringII;

/**
 * 
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * 
 * Example:
 * 
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * 
 * Restrictions:
 * 
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 * 
 * Source: https://leetcode.com/problems/reverse-string-ii/
 */
public class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder(s);
        for (int start = 0; start < s.length(); start += 2 * k) 
            reverse(result, start, Math.min(start + k, s.length()));
        return result.toString();
    }
    private static void reverse(StringBuilder s, int start, int end) {
        s.replace(start, end, reverse(s.substring(start, end)).toString());
    }
    private static CharSequence reverse(CharSequence s) {
        return new StringBuilder(s).reverse();
    }
}
