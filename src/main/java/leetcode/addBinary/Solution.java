package leetcode.addBinary;

import java.math.BigInteger;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * <p>
 * Source: https://leetcode.com/problems/add-binary/
 */
public class Solution {
    public String addBinary(String a, String b) {
        return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
    }
}
