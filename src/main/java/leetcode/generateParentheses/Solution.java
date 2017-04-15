package leetcode.generateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * Source: https://leetcode.com/problems/generate-parentheses/
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        return generateParenthesis(n, n, "", new ArrayList<>());
    }

    private List<String> generateParenthesis(int open, int closed, String result, List<String> results) {
        if (closed == 0) results.add(result);
        else {
            if (open > 0)      generateParenthesis(open - 1, closed, result + "(", results);
            if (closed > open) generateParenthesis(open, closed - 1, result + ")", results);
        }
        return results;
    }
}
