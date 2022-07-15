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
        ListNode sh = null;
        ListNode ts = null;
        ListNode lh = null;
        ListNode tl = null;
        ListNode temp = head;
        while(temp != null) {
            if(temp.val < x) {
                if(sh == null) {
                    sh = temp;
                    ts = temp;
                } else {
                    ts.next = temp;
                    ts = ts.next;
                }
            } else {
                if(lh == null) {
                    lh = temp;
                    tl = temp;
                } else {
                    tl.next = temp;
                    tl = tl.next;
                }
            }
            temp = temp.next;
        }
        if(lh != null) tl.next = null;
        if(sh != null) ts.next = lh;
        
        if(sh != null) {
            return sh;
        } else {
            return lh;
        }
        
    }
}