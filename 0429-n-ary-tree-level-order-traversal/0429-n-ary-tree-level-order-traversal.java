/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        
        if(root == null)
            return levelOrderList;
        
        LinkedList<Node> que = new LinkedList<>();
        
        que.addLast(root);
        while(que.size() != 0) {
            int size = que.size();
            List<Integer> levelList = new ArrayList<>();
            while(size-- > 0) {
                Node rem = que.removeFirst();
                levelList.add(rem.val);
                for(Node child : rem.children) {
                    que.addLast(child);
                }
            }
            levelOrderList.add(levelList);
        }
        
        return levelOrderList;
    }
}