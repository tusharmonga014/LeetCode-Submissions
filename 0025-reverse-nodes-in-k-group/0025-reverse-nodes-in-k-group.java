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
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1)
            return head;
        
        int len = length(head);
        
        ListNode h = null;
        ListNode t = null;
        
        if(k > len) {
            return head;
        }
        
        ListNode cur = head;
        
        while(len >= k) {
            ListNode tt = cur;
            ListNode forw = null;
            ListNode prev = t;
            
            int tempk = k;
            
            while(tempk-- > 0) {
                forw = cur.next;
                cur.next = prev;
                prev = cur;  
                cur = forw;
            }
            
            len -= k;
            
            if(h == null) {
                h = prev;
                t = tt;
            }
            t.next = prev;
            t = tt;
        }
        t.next = cur;
        return h;
    }
}