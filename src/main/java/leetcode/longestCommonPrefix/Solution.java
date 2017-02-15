package leetcode.longestCommonPrefix;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 

 * Source: https://leetcode.com/problems/longest-common-prefix/
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        else {
            String longestPrefix = strs[0];
            for (String s : strs) {
                longestPrefix = commonPrefix(longestPrefix, s);
            }
            return longestPrefix;
        }
    }
    
    String commonPrefix(String a, String b) {
        for (int i = 0, length = Math.min(a.length(), b.length()); i < length; i++)
            if (a.charAt(i) != b.charAt(i))
                return a.substring(0, i);
        return (a.length() < b.length()) ? a : b;
    }
}
