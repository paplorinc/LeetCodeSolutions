package leetcode.removeNthNodeFromEndofList;

import leetcode.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 *
 * Source: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n > 0) {
            int size = size(head);
            if (size == n) head = head.next;
            else {
                ListNode node = head;
                for (int i = size - n - 1; i > 0; i--)
                    node = node.next;
                node.next = node.next.next;
            }
        }
        return head;
    }
    int size(ListNode head) {
        int size = 0;
        for (; head != null; head = head.next)
            size++;
        return size;
    }
}
