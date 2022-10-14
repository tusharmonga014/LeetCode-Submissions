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
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode forw = null;
        
        while(cur != null) {
            forw = cur.next;
            cur.next = prev;
            prev = cur;
            cur = forw;
        }
        
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverse(head2);
        
        ListNode cur1 = head, cur2 = head2;
        while(cur2 != null) {
            ListNode f1 = cur1.next;
            ListNode f2 = cur2.next;
            cur1.next = cur2;
            cur2.next = f1;
            cur1 = f1;
            cur2 = f2;
        }
    }
}