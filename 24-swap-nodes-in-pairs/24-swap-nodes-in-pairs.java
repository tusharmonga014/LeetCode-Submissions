/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null && temp.next != null) {
            ListNode tempNext = temp.next;
            temp.next = tempNext.next;
            if(prev == null) {
                head = tempNext;
            } else {
                prev.next = tempNext;
            }
            tempNext.next = temp;
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}