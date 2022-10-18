//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static class Pair {
        boolean isBst;
        int min;
        int max;
        int count;
        Pair(boolean isBst, int min, int max, int count) {
            this.isBst = isBst;
            this.min = min;
            this.max = max;
            this.count = count;
        }
    }
    static Pair largestBst_(Node root) {
        if(root == null) {
            return new Pair(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Pair lp = largestBst_(root.left);
        Pair rp = largestBst_(root.right);
        
        if(lp.isBst && root.data > lp.max && rp.isBst && root.data < rp.min) {
            return new Pair(true, Math.min(root.data, lp.min), Math.max(root.data, rp.max), lp.count + 1 + rp.count);
        } else {
            return new Pair(false, Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(lp.count, rp.count));
        }
    }
    static int largestBst(Node root) {
        Pair p = largestBst_(root);
        return p.count;
    }
    
}