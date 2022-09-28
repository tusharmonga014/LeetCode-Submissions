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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(n > 0) {
            fast = fast.next;
            n--;
        }
        if(fast == null) {
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newNext = slow.next.next;
        slow.next.next = null;
        slow.next = newNext;
        return head;
    }
}