package leetcode.findAllAnagramsinaString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * <p>
 * Source: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> results = new ArrayList<>();
    Map<Character, Long> balance = p.chars().boxed().collect(groupingBy(i -> (char) i.intValue(), counting()));
    for (int i = 0, remaining = balance.size(); i < s.length(); i++) {
      char prev = (i < p.length()) ? 0 : s.charAt(i - p.length());
      if (Objects.equals(1L, balance.computeIfPresent(prev, (k, v) -> v + 1)))
        remaining++;

      char next = s.charAt(i);
      if (Objects.equals(0L, balance.computeIfPresent(next, (k, v) -> v - 1)))
        remaining--;

      if (remaining == 0)
        results.add(i - p.length() + 1);
    }
    return results;
  }
}
