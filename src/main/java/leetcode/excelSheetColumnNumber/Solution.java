package leetcode.excelSheetColumnNumber;

/**
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * A -&gt; 1
 * B -&gt; 2
 * C -&gt; 3
 * ...
 * Z -&gt; 26
 * AA -&gt; 27
 * AB -&gt; 28
 * 
 * Credits:Special thanks to @ts for adding this problem and creating all test cases.

 * Source: https://leetcode.com/problems/excel-sheet-column-number/
 */
public class Solution {
    private static final int base = 'Z' - ('A' - 1);
    private static final int shift = 'A' - 1;
    public int titleToNumber(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num *= base;
            num += s.charAt(i) - shift;
        }
        return num;
    }
}
