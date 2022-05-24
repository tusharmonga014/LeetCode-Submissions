class Solution {
    public int longestValidParentheses(String s) {
        
        int max = 0;
        
        int[] dp = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            
            char ch = s.charAt(i);
            
            if(ch == '('){
                continue;
            } else if(i > 0) {
                
                if(s.charAt(i - 1) == '('){
                    if(i > 1){
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else {
                    if(dp[i - 1] > 0){
                        if(i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                            if(i - dp[i - 1] - 1 > 0) {
                                dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                            } else {
                                dp[i] = dp[i - 1] + 2;
                            }
                        }
                    }
                }
                
            }
            
            if(dp[i] > max){
                max = dp[i];
            }
        }
        
        return max;   
    }
}