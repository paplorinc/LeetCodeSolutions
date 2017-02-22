package leetcode.decodeString;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Given an encoded string, return it's decoded string.
 * 
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * 
 * 
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * 
 * 
 * Examples:
 * 
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 * 

 * Source: https://leetcode.com/problems/decode-string/
 */
import java.util.regex.*;
import java.util.Collection;

public class Solution {
    final Pattern p = Pattern.compile("(\\d+)\\[([a-z]+)\\]"); 
    public String decodeString(String s) {
        StringBuilder results = new StringBuilder(s);
        for (Matcher m = p.matcher(results); m.find(); m.reset()) {
            String repeated = String.join("", Collections.nCopies(Integer.parseInt(m.group(1)), m.group(2)));
            results.replace(m.start(), m.end(), repeated);
        }
        return results.toString();
    }
}
