package leetcode.powerofThree;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Given an integer, write a function to determine if it is a power of three.
 * 
 * 
 * Follow up:
 * Could you do it without using any loop / recursion?
 * 
 * 
 * Credits:Special thanks to @dietpepsi for adding this problem and creating all test cases.

 * Source: https://leetcode.com/problems/power-of-three/
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        double log3 = Math.log(n) / Math.log(3);
        return n > 0 && Math.pow(3, Math.round(log3)) == n;
    }
}
