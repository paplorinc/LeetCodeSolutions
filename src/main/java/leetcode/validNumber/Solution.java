package leetcode.validNumber;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Validate if a given string is numeric.
 * 
 * 
 * Some examples:
 * "0" => true
 * "   0.1  " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * 
 * 
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 * 
 * 
 * 
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 * 

 * Source: https://leetcode.com/problems/valid-number/
 */
public class Solution {
    private static java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^\\s*[+-]?(\\d+|\\d*\\.\\d+|\\d+\\.\\d*)(e[+-]?\\d+)?\\s*$");
    public boolean isNumber(String s) {
       return pattern.matcher(s).find(); 
    }
}
