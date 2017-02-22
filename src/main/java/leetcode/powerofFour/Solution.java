package leetcode.powerofFour;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * 
 * Example:
 * Given num = 16, return true.
 * Given num = 5, return false.
 * 
 * 
 * Follow up: Could you solve it without loops/recursion?
 * 
 * Credits:Special thanks to @yukuairoy  for adding this problem and creating all test cases.

 * Source: https://leetcode.com/problems/power-of-four/
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        return Integer.bitCount(num) == 1
           && (Integer.numberOfLeadingZeros(num) & 1) == 1;
    }
}