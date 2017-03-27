package leetcode.permutations;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * 
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * 
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * 
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
