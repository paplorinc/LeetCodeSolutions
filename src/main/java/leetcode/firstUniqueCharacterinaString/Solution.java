package leetcode.firstUniqueCharacterinaString;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * 
 * 
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 

 * Source: https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class Solution {
    public int firstUniqChar(String s) {
        java.util.Map<Character, Integer> visited = new java.util.LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            visited.put(s.charAt(i), visited.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (visited.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
