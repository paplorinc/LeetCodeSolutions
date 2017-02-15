package leetcode.zigZagConversion;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * 
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * 
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 

 * Source: https://leetcode.com/problems/zigzag-conversion/
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= numRows) return s;
        else {
            char[] result = new char[s.length()];
            int index = 0, jump = 2 * (numRows - 1);
            for (int r = 0; r < numRows; r++) {
                boolean isExtreme = (r == 0 || r + 1 == numRows);
                int prev = isExtreme ? jump : jump - (2 * r);
                for (int c = r; c < s.length(); ) {
                    result[index++] = s.charAt(c);

                    c += prev;
                    prev = isExtreme ? jump : jump - prev;
                }
            }
            return new String(result);
        }
    }
}
