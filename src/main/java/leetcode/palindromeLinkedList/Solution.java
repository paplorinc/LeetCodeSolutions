package leetcode.palindromeLinkedList;

import leetcode.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * Source: https://leetcode.com/problems/palindrome-linked-list/
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        int mid = (size(head) + 1) >> 1;
        for (ListNode reverse = reverse(head, mid); reverse != null; head = head.next, reverse = reverse.next)
            if (head.val != reverse.val)
                return false;
        return true;
    }

    int size(ListNode head) {
        int size = 0;
        for (; head != null; head = head.next)
            size++;
        return size;
    }

    ListNode reverse(ListNode head, int skip) {
        for (; skip > 0; skip--)
            head = head.next;

        ListNode previous = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = previous;

            previous = head;
            head = next;
        }
        return previous;
    }
}
