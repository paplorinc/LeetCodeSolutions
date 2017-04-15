package leetcode.longestPalindrome;

import java.util.BitSet;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * Example:
 * Input:
 * "abccccdd"
 * Output:
 * 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 * Source: https://leetcode.com/problems/longest-palindrome/
 */
public class Solution {
    public int longestPalindrome(String s) {
        BitSet bitSet = new BitSet('Z');
        for (int i = 0; i < s.length(); i++)
            bitSet.flip(s.charAt(i));
        return s.length() - Math.max(0, bitSet.cardinality() - 1);
    }
}
