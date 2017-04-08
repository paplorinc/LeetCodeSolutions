package leetcode.longestPalindromicSubstring;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * 
 * Example:
 * 
 * Input: "babad"
 * 
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer.
 * 
 * Example:
 * 
 * Input: "cbbd"
 * 
 * Output: "bb"
 * 
 * Source: https://leetcode.com/problems/longest-palindromic-substring/
 */
public class Solution {
        public String longestPalindrome(String s) {
        int maxLength = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String palindrome = palindromeAt(s, i);
            if (palindrome.length() > maxLength) {
                maxLength = palindrome.length();
                result = palindrome;
            }
        }
        return result;
    }

    String palindromeAt(String s, int index) {
        int maxLength = 1;
        for (int i = 0; i < 2; i++) {
            int length = i;
            for (int start = index - 1, end = index + i; start >= 0 && end < s.length(); start--, end++)
                if (s.charAt(start) == s.charAt(end)) length += 2;
                else break;
            maxLength = Math.max(maxLength, length);
        }

        int start = index - (maxLength / 2);
        return s.substring(start, start + maxLength);
    }
}
