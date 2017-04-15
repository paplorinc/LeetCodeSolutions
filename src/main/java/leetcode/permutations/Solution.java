package leetcode.permutations;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * Source: https://leetcode.com/problems/permutations/
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) { return permute(nums, new LinkedHashSet<>(), new ArrayList<>()); }
    private List<List<Integer>> permute(int[] nums, Set<Integer> result, List<List<Integer>> results) {
        if (result.size() == nums.length) results.add(new ArrayList<>(result));
        else for (int num : nums)
                 if (result.add(num)) {
                     permute(nums, result, results);
                     result.remove(num);
                 }
        return results;
    }
}
