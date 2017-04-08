package leetcode.complexNumberMultiplication;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Given two strings representing two complex numbers.
 * <p>
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 * <p>
 * Example 1:
 * <p>
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * <p>
 * Example 2:
 * <p>
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * <p>
 * Note:
 * <p>
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
 * <p>
 * Source: https://leetcode.com/problems/complex-number-multiplication/
 */
public class Solution {
    public String complexNumberMultiply(String a, String b) {
        return ((Function<int[], String>) vs -> (vs[0] * vs[2] - vs[1] * vs[3]) + "+" + (vs[1] * vs[2] + vs[0] * vs[3]) + "i").apply(Arrays.stream((a + b).split("[+i]")).mapToInt(Integer::parseInt).toArray());
    }
}
