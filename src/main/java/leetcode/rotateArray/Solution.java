package leetcode.rotateArray;

/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * 
 * [show hint]
 * Hint:
 * Could you do it in-place with O(1) extra space?
 * 
 * Related problem: Reverse Words in a String II
 * 
 * Credits:Special thanks to @Freezen for adding this problem and creating all test cases.

 * Source: https://leetcode.com/problems/rotate-array/
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int[] copy = nums.clone();
        for (int i = 0; i < nums.length; i++)
            nums[(i + k) % nums.length] = copy[i];
    }
}
