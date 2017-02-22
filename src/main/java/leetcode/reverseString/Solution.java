package leetcode.reverseString;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * 
 * 
 * Example:
 * Given s = "hello", return "olleh".
 * 

 * Source: https://leetcode.com/problems/reverse-string/
 */
public class Solution {
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
