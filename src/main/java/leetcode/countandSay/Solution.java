package leetcode.countandSay;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * 
 * 
 * Given an integer n, generate the nth sequence.
 * 
 * 
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * 

 * Source: https://leetcode.com/problems/count-and-say/
 */
import java.util.regex.*;
public class Solution {
    private final Pattern p = Pattern.compile("(\\d)\\1*");
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder next = new StringBuilder();
            for (Matcher m = p.matcher(result); m.find(); )
                next.append(m.group().length() + m.group(1));
            result = next.toString();
        }
        return result;
    }
}
