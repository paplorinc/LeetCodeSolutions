package leetcode.ransomNote;

import java.util.HashMap;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom
 * note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 * Source: https://leetcode.com/problems/ransom-note/
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        java.util.Map<Integer, Integer> count = new HashMap<>(magazine.length());
        magazine.chars().forEach(c -> count.compute(c, (k, v) -> (v == null) ? 1 : v + 1));
        return ransomNote.chars().allMatch(c -> {
            final Integer value = count.computeIfPresent(c, (k, v) -> v - 1);
            return value != null && value >= 0;
        });
    }
}
