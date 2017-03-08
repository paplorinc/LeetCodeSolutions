package leetcode.houseRobber;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import leetcode.*;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 * Credits:Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.

 * Source: https://leetcode.com/problems/house-robber/
 */
public class Solution {
    public int rob(int[] nums) {
        int s1 = 0, s2 = 0;
        for (int num : nums) {
            int sum = Math.max(s1, s2 + num);
            s2 = s1;
            s1 = sum;
        }
        return Math.max(s1, s2);
    }
}
