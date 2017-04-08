package leetcode.basicCalculator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces  .
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Some examples:
 * <p>
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * <p>
 * Note: Do not use the eval built-in library function.
 * <p>
 * Source: https://leetcode.com/problems/basic-calculator/
 */
public class Solution {
    public int calculate(String s) {
        int result = 0;
        Deque<Integer> signs = new ArrayDeque<>(Arrays.asList(1));
        for (Matcher m = Pattern.compile("([+-]?)\\s*(?:(\\d+)|([(])|[)])").matcher(s); m.find(); ) {
            int sign = signs.peek() * ("-".equals(m.group(1)) ? -1 : +1);
            if (m.group(2) != null) result += sign * Integer.parseInt(m.group(2));
            else if (m.group(3) != null) signs.push(sign);
            else signs.pop();
        }
        return result;
    }
}
