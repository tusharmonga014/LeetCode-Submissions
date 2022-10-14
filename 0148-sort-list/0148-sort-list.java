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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode c1 = l1;
        ListNode c2 = l2;
        
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        while(c1 != null && c2 != null) {
            if(c1.val <= c2.val) {
                prev.next = c1;
                prev = prev.next;
                c1 = c1.next;
            } else {
                prev.next = c2;
                prev = prev.next;
                c2 = c2.next;
            }
        }
        if(c1 != null) {
            prev.next = c1;
        }
        if(c2 != null) {
            prev.next = c2;
        }
        return head.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        
        return mergeTwoLists(sortList(head), sortList(head2));
    }
}