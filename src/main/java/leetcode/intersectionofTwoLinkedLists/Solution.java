package leetcode.intersectionofTwoLinkedLists;

import leetcode.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * Credits:Special thanks to @stellari for adding this problem and creating all test cases.
 *
 * Source: https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = size(headA), sizeB = size(headB);
        if (sizeB > sizeA) for (int i = 0; i < sizeB - sizeA; i++) headB = headB.next;
        else               for (int i = 0; i < sizeA - sizeB; i++) headA = headA.next;

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    int size(ListNode head) {
        int size = 0;
        for (; head != null; head = head.next) size++;
        return size;
    }
}
