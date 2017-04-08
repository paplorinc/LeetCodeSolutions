package leetcode.removeDuplicatesfromSortedList;

import leetcode.ListNode;

/**
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * Source: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
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
    public ListNode deleteDuplicates(ListNode head) {
        for (ListNode node = head; node != null; node = node.next) {
            ListNode copy = node.next;
            while (copy != null && node.val == copy.val)
                copy = copy.next;
            node.next = copy;
        }
        return head;
    }
}

// 1
