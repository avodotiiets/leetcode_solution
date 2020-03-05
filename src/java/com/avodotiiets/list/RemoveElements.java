package com.avodotiiets.list;

import com.avodotiiets.LeetcodeLink;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
@LeetcodeLink("https://leetcode.com/problems/remove-linked-list-elements/")
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode newHead = head;

        while (curr != null) {
            if (curr.val == val) {
                // remove curr
                if (curr == newHead) {
                    // is head
                    newHead = curr.next;
                } else {
                    // is tail or middle
                    prev.next = curr.next;
                }
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        return newHead;
    }
}
