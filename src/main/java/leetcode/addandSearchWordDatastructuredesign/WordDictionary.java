package leetcode.addandSearchWordDatastructuredesign;

import java.util.*;

/**
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * For example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * click to show hint.
 * You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
 *
 * Source: https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */
public class WordDictionary {
    private final Node root = new Node();

    public void addWord(String word) {
        Node node = root;
        for (char c : word.toCharArray())
            node = node.children.computeIfAbsent(c, k -> new Node());
        node.terminal = word;
    }

    public boolean search(String word) {
        Deque<Node> level = new ArrayDeque<>(Arrays.asList(root));
        for (char c : word.toCharArray())
            for (int i = level.size(); i > 0; i--) {
                Map<Character, Node> children = level.removeFirst().children;
                switch (c) {
                    case '.': level.addAll(children.values()); break;
                    default: if (children.containsKey(c)) level.addLast(children.get(c)); break;
                }
            }
        return level.stream().anyMatch(n -> n.terminal != null);
    }

    private class Node {
        public Map<Character, Node> children = new HashMap<>();
        public String terminal;
    }
}
