class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int r[] = new int[n];
        for(int i = 0; i < n; i++) {
            if(dominoes.charAt(i) == 'R') {
                r[i] = 1;
            } else if(i > 0 && dominoes.charAt(i) == '.' && r[i - 1] > 0) {
                r[i] = r[i - 1] + 1;
            }
        }
        int l[] = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            if(dominoes.charAt(i) == 'L') {
                l[i] = 1;
            } else if(i < n - 1 && dominoes.charAt(i) == '.' && l[i + 1] > 0) {
                l[i] = l[i + 1] + 1;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(l[i] == 0 && r[i] == 0) {
                sb.append(".");
            } else if(l[i] != 0 && r[i] != 0) {
                if(l[i] < r[i]) {
                    sb.append("L");
                } else if(l[i] > r[i]) {
                    sb.append("R");
                } else {
                    sb.append(".");
                }
            } else if(l[i] != 0) {
                sb.append("L");
            } else {
                sb.append("R");
            }
        }
        
        return sb.toString();
    }
}