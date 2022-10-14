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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        while(cur != null) {
            ListNode ahead = cur.next;
            while(ahead != null && cur.val == ahead.val) {
                ahead = ahead.next;
            }
            cur.next = ahead;
            cur = cur.next;
        }
        return head;
    }
}