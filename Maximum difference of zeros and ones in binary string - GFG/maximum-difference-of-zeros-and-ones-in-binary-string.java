// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.maxSubstring(s));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int maxSubstring(String S) {
        int csum = 0;
        int osum = 0;
        
        for(int i = 0; i < S.length(); i++) {
            if(csum >= 0) {
                csum += (S.charAt(i) == '1' ? -1 : 1);
            } else {
                csum = (S.charAt(i) == '1' ? -1 : 1);
            }
            
            osum = Math.max(osum, csum);
        }
        
        return osum == 0 ? -1 : osum;
    }
}