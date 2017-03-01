package leetcode.findAllDuplicatesinanArray;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * Given an array of integers, 1 &le; a[i] &le; n (n = size of array), some elements appear twice and others appear once.
 * 
 * Find all the elements that appear twice in this array.
 * 
 * Could you do it without extra space and in O(n) runtime?
 * 
 * Example:
 * 
 * Input:
 * [4,3,2,7,8,2,3,1]
 * 
 * Output:
 * [2,3]
 * 

 * Source: https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        BitSet found = new BitSet(nums.length + 1);
        List<Integer> results = new ArrayList<>(nums.length);
        for (int num : nums)
            if (found.get(num)) results.add(num);
            else found.set(num);
        return results;
    }
}
