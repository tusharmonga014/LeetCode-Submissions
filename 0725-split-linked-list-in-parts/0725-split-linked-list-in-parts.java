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
    public int len(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int l = len(head);
        int ndk = l / k;
        int nmk = l % k;
        
        ListNode ans[] = new ListNode[k];
        int ik = 0;
        
        ListNode cur = head;
        while(ik < k && cur != null) {
            int tndk = ndk;
            
            ListNode dummy = new ListNode(-1);
            ListNode curdummy = dummy;
            while(tndk-- > 0 && cur != null) {
                curdummy.next = cur;
                cur = cur.next;
                curdummy = curdummy.next;
            }
            if(nmk-- > 0 && cur != null) {
                curdummy.next = cur;
                cur = cur.next;
                curdummy = curdummy.next;
            }
            
            curdummy.next = null;
            
            ans[ik++] = dummy.next;
        }
        
        return ans;
    }
}