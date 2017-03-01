package leetcode.validPalindrome;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * 
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * 
 * 
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 

 * Source: https://leetcode.com/problems/valid-palindrome/
 */
public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("\\W+", "");
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
