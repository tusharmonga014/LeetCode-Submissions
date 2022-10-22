class Solution {
    public List<List<String>> partition(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        for(int g = 0; g < s.length(); g++) {
            for(int i = 0, j = g; j < s.length(); i++, j++) {
                if(i == j) { // g == 0
                    dp[i][j] = true;
                } else if(g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
            }
        }
        
        a = new ArrayList<>();
        ans(s, 0, dp, new ArrayList<>());
        
        return a;
    }
    
    public List<List<String>> a;
    public void ans(String s, int idx, boolean[][] dp, List<String> aa) {
        if(idx == s.length()) {
            List<String> base = new ArrayList<>();
            base.addAll(aa);
            a.add(base);
            return;
        }
        
        for(int i = idx; i < s.length(); i++) {
            if(dp[idx][i]) {
                aa.add(s.substring(idx, i + 1));
                ans(s, i + 1, dp, aa);
                aa.remove(aa.size() - 1);
            }
        }
    }
}