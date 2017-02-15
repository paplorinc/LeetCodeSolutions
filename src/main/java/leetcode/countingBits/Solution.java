package leetcode.countingBits;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 &le; i &le; num calculate the number of 1's in their binary representation and return them as an array.
 * 
 * 
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * 
 * 
 * Follow up:
 * 
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount  in c++ or in any other language.
 * 
 * 
 * 
 * 
 * You should make use of what you have produced already.
 * Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
 * Or does the odd/even status of the number help you in calculating the number of 1s?
 * 
 * 
 * Credits:Special thanks to @ syedee  for adding this problem and creating all test cases.

 * Source: https://leetcode.com/problems/counting-bits/
 */
public class Solution {
    public int[] countBits(int num) {
        int[] results = new int[num + 1];
        for (int i = 0; i <= num; i++)
            results[i] = Integer.bitCount(i);
        return results;
    }
}