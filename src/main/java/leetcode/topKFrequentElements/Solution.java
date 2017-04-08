package leetcode.topKFrequentElements;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * <p>
 * Note:
 * <p>
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * <p>
 * Source: https://leetcode.com/problems/top-k-frequent-elements/
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Long> frequencies = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        long limit = countLimit(frequencies.values(), k);
        return frequencies.entrySet().stream()
                          .filter(e -> e.getValue() >= limit)
                          .limit(k)
                          .map(Map.Entry::getKey).collect(Collectors.toList());
    }
    private static long countLimit(Collection<Long> values, int k) {
        return values.stream()
                     .sorted(Comparator.reverseOrder())
                     .skip(k - 1)
                     .findFirst().orElse(1L); 
    }
}
