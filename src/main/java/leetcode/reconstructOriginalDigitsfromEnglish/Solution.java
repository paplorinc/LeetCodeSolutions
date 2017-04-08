package leetcode.reconstructOriginalDigitsfromEnglish;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
 * 
 * Note:
 * 
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 * 
 * Example 1:
 * 
 * Input: "owoztneoer"
 * 
 * Output: "012"
 * 
 * Example 2:
 * 
 * Input: "fviefuro"
 * 
 * Output: "45"
 * 
 * Source: https://leetcode.com/problems/reconstruct-original-digits-from-english/
 */
public class Solution {
    private static final String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final int[] digitSearchOrder = {0, 2, 6, 8, 3, 4, 5, 7, 1, 9}; // based on unique chars: z,w,x,g,h,r,f,v,o,i

    public String originalDigits(String s) {
        int[] digits = new int[10];
        final Map<Integer, Long> frequencies = s.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (int i : digitSearchOrder)
            while (contains(frequencies, i)) {
                subtract(frequencies, i);
                digits[i]++;
            }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < digits.length; i++)
            for (int j = 0; j < digits[i]; j++)
                result.append(i);
        return result.toString();
    }

    private boolean contains(Map<Integer, Long> frequencies, int i) {
        return digits[i].chars().allMatch(frequencies::containsKey);
    }

    private void subtract(Map<Integer, Long> frequencies, int i) {
        digits[i].chars().forEach(c -> frequencies.computeIfPresent(c, (k, v) -> (v == 1) ? null : v - 1));
    }
}
