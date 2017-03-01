package leetcode.excelSheetColumnTitle;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * 
 * Credits:Special thanks to @ifanchu for adding this problem and creating all test cases.

 * Source: https://leetcode.com/problems/excel-sheet-column-title/
 */
public class Solution {
    private static final int radix = ('Z' - 'A') + 1;
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        for (; n-- > 0; n /= radix)
            result.append((char)('A' + (n % radix)));
        return result.reverse().toString();
    }
}
