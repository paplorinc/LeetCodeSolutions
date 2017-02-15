package leetcode.validAnagram;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * 
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * 
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?

 * Source: https://leetcode.com/problems/valid-anagram/
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        return Arrays.equals(sorted(s), sorted(t));
    }
    
    char[] sorted(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return chars;
    }
}
