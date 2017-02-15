package leetcode.powerofTwo;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * 
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

 * Source: https://leetcode.com/problems/power-of-two/
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
}
