class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        char[] chars=s.toCharArray();
        Integer[][] dp=new Integer[chars.length+1][k+1];
        return dfs(chars,0,k,dp);
    }
    
    int dfs(char[] chars,int idx,int k,Integer[][] dp){
        if(k<0) return 101;
        if(dp[idx][k]==null) {
            // if there is no more than k chars left, delete all
            if(idx+k>=chars.length) {
                dp[idx][k]=0;
            } else {
                int[] cnt=new int[128];
                int most=0,best=101;
                for(int j=idx;j<chars.length;j++) {
                    cnt[chars[j]]++;
                    most=Math.max(most,cnt[chars[j]]);
                    // delete [idx,j] but keep chars with most counts
                    best=Math.min(best,len(most)+dfs(chars,j+1,k-j+idx-1+most,dp));
                }
                dp[idx][k]=best;
            }
        }
        return dp[idx][k];
    }
    
    int len(int most) {
        if(most==0) return 0;
        if(most==1) return 1;
        if(most<10) return 2;
        if(most<100) return 3;
        return 4;
    }
}
