class Solution {
    ArrayList<Integer> gp[];
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        gp = new ArrayList[s.length()];
        for(int i = 0; i < s.length(); i++) {
            gp[i] = new ArrayList<>();
        }
        
        for(int i = 0; i <pairs.size(); i++) {
            int u = pairs.get(i).get(0);
            int v = pairs.get(i).get(1);
            gp[u].add(v);
            gp[v].add(u);
        }
        
        boolean vis[] = new boolean[s.length()];
        char ans[] = new char[s.length()];
        for(int i = 0; i < s.length(); i++) {
            if(!vis[i]) {
                ArrayList<Integer> idxs = new ArrayList<>();
                dfs(i, vis, idxs);
                fill(s, ans, idxs);
            }
        }
        
        return String.copyValueOf(ans);
    }
    
    public void dfs(int i, boolean[] vis, ArrayList<Integer> idxs) {
        vis[i] = true;
        idxs.add(i);
        for(int nei = 0; nei < gp[i].size(); nei++) {
            if(!vis[gp[i].get(nei)]) {
                dfs(gp[i].get(nei), vis, idxs);
            }
        }
    }
    
    public void fill(String s, char[] ans, ArrayList<Integer> idxs) {
        int ch[] = new int[26];
        Collections.sort(idxs);
        for(int i = 0; i < idxs.size(); i++) {
            ch[s.charAt(idxs.get(i)) - 'a']++;
        }
        
        for(int i = 0; i < idxs.size(); i++) {
            for(int c = 0; c < 26; c++) {
                if(ch[c] > 0) {
                    ans[idxs.get(i)] = (char)(c + 'a');
                    ch[c]--;
                    break;
                }
            }
        }
    }
}