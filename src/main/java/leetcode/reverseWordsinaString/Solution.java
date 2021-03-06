package leetcode.reverseWordsinaString;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * Update (2015-02-12):
 * For C programmers: Try to solve it in-place in O(1) space.
 * click to show clarification.
 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 *
 * Source: https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class Solution {
    public String reverseWords(String s) {
        return Arrays.stream(reverse(s.trim()).split(" +"))
                     .map(Solution::reverse)
                     .collect(Collectors.joining(" "));
    }
    private static String reverse(String s) { return new StringBuilder(s).reverse().toString(); }
}
