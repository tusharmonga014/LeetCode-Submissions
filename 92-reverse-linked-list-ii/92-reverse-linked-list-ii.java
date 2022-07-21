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
        if(head == null || head.next == null)
            return head;
        int size = 1;
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null && size < right) {
            if(size == left) {
                ListNode oTemp = temp;
                ListNode cur = temp;
                ListNode p = null;
                while(cur != null && size <= right) {
                    ListNode next = cur.next;
                    cur.next = p;
                    p = cur;
                    cur = next;
                    size++;
                }
                if(prev != null) {
                    prev.next = p;
                } else {
                    head = p;
                }
                oTemp.next = cur;
            }
            size++;
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}