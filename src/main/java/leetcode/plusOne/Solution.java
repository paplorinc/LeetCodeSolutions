package leetcode.plusOne;

import java.math.BigInteger;
import java.util.Arrays;

import static java.util.stream.Collectors.joining;

/**
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * <p>
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * Source: https://leetcode.com/problems/plus-one/
 */

public class Solution {
    public int[] plusOne(int[] digits) {
        String digitsString = Arrays.stream(digits).mapToObj(String::valueOf).collect(joining(""));
        BigInteger plusOne = new BigInteger(digitsString).add(BigInteger.ONE);
        return plusOne.toString().chars().map(Character::getNumericValue).toArray();
    }
}
