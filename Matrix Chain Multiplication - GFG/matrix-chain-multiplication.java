// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        int dp[][] = new int[N - 1][N - 1];
        for(int g = 0; g < N - 1; g++) {
            for(int i = 0, j = g; j < N - 1; i++, j++) {
                if(g == 0) {
                    dp[i][j] = 0;
                } else if(g == 1) {
                    dp[i][j] = arr[i] * arr[i + 1] * arr[j + 1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for(int k = i; k < j; k++) {
                        int l = dp[i][k];
                        int r = dp[k + 1][j];
                        int m = arr[i] * arr[k + 1] * arr[j + 1];
                        min = Math.min(min, l + r + m);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][N - 1 - 1];
    }
}