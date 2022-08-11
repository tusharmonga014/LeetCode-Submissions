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
        ListNode temp = head;
        ListNode prev = null;
        ListNode fast = head;
        while(n-- > 0) {
            fast = fast.next;
        }
        while(fast != null) {
            prev = temp;
            temp = temp.next;
            fast = fast.next;
        }
        if(prev == null) {
            return head.next;
        }
        ListNode tempNext = temp.next;
        temp.next = null;
        prev.next = tempNext;
        return head;
    }
}