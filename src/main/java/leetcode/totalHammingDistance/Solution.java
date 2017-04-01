package leetcode.totalHammingDistance;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * 
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.
 * 
 * 
 * Example:
 * 
 * Input: 4, 14, 2
 * 
 * Output: 6
 * 
 * Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
 * showing the four bits relevant in this case). So the answer will be:
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * 
 * 
 * 
 * Note:
 * 
 * Elements of the given array are in the range of 0  to 10^9
 * Length of the array will not exceed 10^4.
 * 
 * 

 * Source: https://leetcode.com/problems/total-hamming-distance/
 */
public class Solution {
    public int totalHammingDistance(int... nums) {
        List<String> binaries = Arrays.stream(nums).mapToObj(Integer::toBinaryString).collect(Collectors.toList());
        Stream<int[]> digits = IntStream.range(0, Integer.SIZE)
                .mapToObj(i -> binaries.stream().mapToInt(s -> i >= s.length() ? '0' : s.charAt(s.length() - 1 - i)).toArray());
        return digits.mapToInt((int[] a) -> {
            long zeros = Arrays.stream(a).filter(i -> i == '0').count();
            long ones = Arrays.stream(a).filter(i -> i == '1').count();
            return (int) (zeros * ones);
        }).sum();
    }
}
