package leetcode.numberofSegmentsinaString;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * 
 * Please note that the string does not contain any non-printable characters.
 * 
 * Example:
 * 
 * Input: "Hello, my name is John"
 * Output: 5
 * 
 * 

 * Source: https://leetcode.com/problems/number-of-segments-in-a-string/
 */
import java.util.regex.*;
public class Solution {
    private static final Pattern p = Pattern.compile("\\S+");
    public int countSegments(String s) {
        int result = 0;
        for (Matcher m = p.matcher(s); m.find(); )
            result++;
        return result;
    }
}
