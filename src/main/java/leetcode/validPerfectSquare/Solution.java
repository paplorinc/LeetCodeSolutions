package leetcode.validPerfectSquare;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * 
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * 
 * Example 1:
 * 
 * Input: 16
 * Returns: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 14
 * Returns: False
 * 
 * 
 * 
 * Credits:Special thanks to @elmirap for adding this problem and creating all test cases.

 * Source: https://leetcode.com/problems/valid-perfect-square/
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        int root = (int) Math.sqrt(num);
        return (root * root) == num;
    }
}
