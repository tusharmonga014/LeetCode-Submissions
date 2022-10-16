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
    public ListNode partition(ListNode head, int x) {
        ListNode gt = new ListNode(-1);
        ListNode sm = new ListNode(-1);
        
        ListNode g = gt;
        ListNode s = sm;
        
        ListNode cur = head;
        
        while(cur != null) {
            if(cur.val < x) {
                s.next = cur;
                s = s.next;
            } else {
                g.next = cur;
                g = g.next;
            }
            
            ListNode forw = cur.next;
            cur.next = null;
            cur = forw;
        }
        
        s.next = gt.next;
        return sm.next;
    }
}