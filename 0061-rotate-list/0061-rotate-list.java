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
    public int length(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        int len = length(head);
        k = k % len;
        if(k == 0) return head;
        ListNode slow = head, fast = head;
        while(k-- > 0) {
            fast = fast.next;
        }
        if(fast == null)
            return head;
        
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode nHead = slow.next;
        fast.next = head;
        slow.next = null;
        return nHead;
    }
}