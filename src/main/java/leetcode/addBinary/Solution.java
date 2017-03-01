package leetcode.addBinary;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Given two binary strings, return their sum (also a binary string).
 * 
 * 
 * 
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * 

 * Source: https://leetcode.com/problems/add-binary/
 */
import java.math.BigInteger;
public class Solution {
    public String addBinary(String a, String b) {
        return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
    }
}
