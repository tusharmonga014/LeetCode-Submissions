class Solution {
    public int minCut(String s) {
		boolean dp[][] = new boolean[s.length()][s.length()];

		for(int g = 0; g < s.length(); g++) {
			for(int i = 0, j = g; j < s.length(); i++, j++) {
				if(g == 0) {
					dp[i][j] = true;
				} else if(g == 1) {
					dp[i][j] = s.charAt(i) == s.charAt(j);
				} else {
					dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
				}
			}
		}

		int ndp[] = new int[s.length()];
		for(int j = 1; j < s.length(); j++) {
			if(dp[0][j]) {
				ndp[j] = 0;
			} else {
				int min = Integer.MAX_VALUE;
				for(int i = j; i >= 0; i--) {
					if(dp[i][j]) {
						min = Math.min(min, ndp[i - 1]);
					}
				}
				ndp[j] = min + 1;
			}
		}

		return ndp[s.length() - 1];
    }
}