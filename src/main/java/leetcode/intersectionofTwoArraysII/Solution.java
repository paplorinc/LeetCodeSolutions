package leetcode.intersectionofTwoArraysII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 * Source: https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        return intersect(groupByFrequency(nums1), groupByFrequency(nums2)).entrySet().stream()
              .flatMapToInt(e -> Stream.generate(e::getKey).limit(e.getValue()).mapToInt(i -> i))
              .toArray();
    }

    Map<Integer, Long> intersect(Map<Integer, Long> nums1Freqs, Map<Integer, Long> nums2Freqs) {
        Map<Integer, Long> smaller = (nums1Freqs.size() < nums2Freqs.size()) ? nums1Freqs : nums2Freqs;
        Map<Integer, Long> greater = (nums1Freqs.size() < nums2Freqs.size()) ? nums2Freqs : nums1Freqs;

        Map<Integer, Long> results = new HashMap<>();
        for (Map.Entry<Integer, Long> e : smaller.entrySet())
            results.put(e.getKey(), Math.min(e.getValue(), greater.getOrDefault(e.getKey(), 0L)));
        return results;
    }

    Map<Integer, Long> groupByFrequency(int[] nums) {
        return Arrays.stream(nums).boxed()
              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
