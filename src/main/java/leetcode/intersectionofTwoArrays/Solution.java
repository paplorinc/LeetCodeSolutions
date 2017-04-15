package leetcode.intersectionofTwoArrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 * Source: https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] min = (nums2.length > nums1.length) ? nums1 : nums2;
        int[] max = (nums2.length > nums1.length) ? nums2 : nums1;
        Set<Integer> set = Arrays.stream(min).boxed().collect(Collectors.toSet());
        return Arrays.stream(max).filter(set::remove).toArray();
    }
}
