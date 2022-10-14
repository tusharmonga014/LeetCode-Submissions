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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        
        ListNode c1 = head;
        ListNode nhead = head.next;
        ListNode c2 = nhead;
        while(c1.next != null && c2.next != null) {
            c1.next = c1.next.next;
            c2.next = c1.next.next;
            c1 = c1.next;
            c2 = c2.next;
        }
        c1.next = nhead;
        return head;
    }
}