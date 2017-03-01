package leetcode.lengthofLastWord;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * 
 * For example,
 * Given s = "Hello World",
 * return 5.
 * 

 * Source: https://leetcode.com/problems/length-of-last-word/
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.length() - (s.lastIndexOf(' ') + 1);
    }
}
