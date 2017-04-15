package leetcode.summaryRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 *
 * Source: https://leetcode.com/problems/summary-ranges/
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> results = new ArrayList<>();
        for (int start = 0, end = 1; end <= nums.length; end++)
            if ((end == nums.length) || ((1 + nums[end - 1]) != nums[end])) {
                String suffix = (1 + start != end) ? "->" + nums[end - 1] : "";
                results.add(nums[start] + suffix);
                start = end;
            }
        return results;
    }
}
