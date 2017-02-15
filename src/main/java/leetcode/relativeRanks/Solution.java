package leetcode.relativeRanks;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * 
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 * 
 * Example 1:
 * 
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". For the left two athletes, you just need to output their relative ranks according to their scores.
 * 
 * 
 * 
 * Note:
 * 
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 * 
 * 

 * Source: https://leetcode.com/problems/relative-ranks/
 */
public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> ranks = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++)
            ranks.put(nums[i], i);
        
        String[] results = new String[nums.length];
        int i = 1;
        for (Map.Entry<Integer, Integer> e : ranks.entrySet())
            results[e.getValue()] = getName(i++);
        return results;
    }
    
    String getName(int ordinal) {
        switch (ordinal) {
            case 1:  return "Gold Medal";
            case 2:  return "Silver Medal";
            case 3:  return "Bronze Medal";
            default: return String.valueOf(ordinal);
        }
    }
}
