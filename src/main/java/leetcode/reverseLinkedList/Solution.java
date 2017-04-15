package leetcode.reverseLinkedList;

import leetcode.ListNode;

/**
 * Reverse a singly linked list.
 * click to show more hints.
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * Source: https://leetcode.com/problems/reverse-linked-list/
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
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        while (head != null) {
            ListNode copy = head.next;
            head.next = previous;
            previous = head;
            head = copy;
        }
        return previous;
    }
}
