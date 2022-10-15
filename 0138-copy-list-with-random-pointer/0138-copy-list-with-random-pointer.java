/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        
        Node cur = head;
        while(cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            
            cur = cur.next.next;
        }
        
        cur = head;
        while(cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        
        Node head2 = null;
        Node tail2 = null;
        
        cur = head;
        while(cur != null) {
            Node cur2 = cur.next;
            cur.next = cur.next.next;
            
            if(head2 == null) {
                head2 = cur2;
                tail2 = cur2;
            } else {
                tail2.next = cur2;
                tail2 = tail2.next;
            }
            
            cur = cur.next;
        }
        
        return head2;
    }
}