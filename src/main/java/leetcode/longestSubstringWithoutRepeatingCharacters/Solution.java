package leetcode.longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Source: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>(s.length());
        int maxCount = 0;
        for (int i = 0, lastDuplicateIndex = -1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (lastIndex.containsKey(c)) {
                lastDuplicateIndex = Math.max(lastDuplicateIndex, lastIndex.get(c));
            }
            maxCount = Math.max(maxCount, i - lastDuplicateIndex);
            lastIndex.put(c, i);
        }
        return maxCount;
    }
}
