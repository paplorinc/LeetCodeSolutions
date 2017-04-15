package leetcode.linkedListCycle;

import leetcode.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 *
 * Source: https://leetcode.com/problems/linked-list-cycle/
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head != null)
            for (ListNode slow = head, fast = head.next; slow != null && fast != null && fast.next != null; slow = slow.next, fast = fast.next.next)
                if (slow == fast)
                    return true;
        return false;
    }
}
