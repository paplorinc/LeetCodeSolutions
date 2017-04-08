package leetcode.reverseVowelsofaString;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * 
 * Example 1:
 * Given s = "hello", return "holle".
 * 
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * 
 * Note:
 * The vowels does not include the letter "y".
 * 
 * Source: https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class Solution {
    public String reverseVowels(String s) {
        StringBuilder result = new StringBuilder(s);
        for (int start = 0, end = s.length() - 1; start < end; ) {
            boolean isStartVowel = isVowel(s.charAt(start)), isEndVowel = isVowel(s.charAt(end));
            if (isStartVowel && isEndVowel) {
                result.setCharAt(start, s.charAt(end));
                result.setCharAt(end, s.charAt(start));
                end--;
                start++;
            } else if (!isStartVowel) start++;
            else if (!isEndVowel) end--;
        }
        return result.toString();
    }
    boolean isVowel(char c) {
        switch(Character.toLowerCase(c)) {
            case 'e': case 'u': case 'i': case 'o': case 'a': return true;
            default: return false;
        }
    }
}
