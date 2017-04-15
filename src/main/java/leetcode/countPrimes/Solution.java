package leetcode.countPrimes;

import java.util.BitSet;

/**
 * Description:
 * Count the number of prime numbers less than a non-negative number, n.
 * Credits:Special thanks to @mithmatt for adding this problem and creating all test cases.
 *
 * Source: https://leetcode.com/problems/count-primes/
 */
public class Solution {
    public int countPrimes(int n) {
        BitSet compounds = new BitSet(n);
        for (int i = 2, end = (int) Math.sqrt(n); i <= end; i = compounds.nextClearBit(i + 1))
            for (int j = i * i; j < n; j += i)
                compounds.set(j);
        return Math.max(0, n - (compounds.cardinality() + 2));
    }
}
