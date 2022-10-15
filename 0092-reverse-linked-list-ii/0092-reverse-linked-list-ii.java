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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;
        
        int idx = 1;
        ListNode cur = head;
        
        ListNode oprev = null;
        while(idx < left) {
            oprev = cur;
            cur = cur.next;
            idx++;
        }
        
        ListNode prev = null;
        ListNode forw = null;
        
        while(idx <= right) {
            forw = cur.next;
            cur.next = prev;
            prev = cur;
            cur = forw;
            idx++;
        }
        
        if(left == 1) {
            head.next = forw;
            return prev;
        } else {
            ListNode curTail = oprev.next;
            oprev.next = prev;
            curTail.next = forw;
            return head;
        }
    }
}