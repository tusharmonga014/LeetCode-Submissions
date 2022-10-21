class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> gp = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            gp.add(new ArrayList<>());
        for(int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            gp.get(u).add(v);
        }
        boolean vis[] = new boolean[numCourses];  
        ArrayList<Integer> stack = new ArrayList<>();
        boolean cyclef = false;
        for(int i = 0; i < numCourses; i++) {
            if(!vis[i]) {
                boolean cycle[] = new boolean[numCourses];
                cyclef = cyclef || dfs(gp, i, vis, cycle, stack);
            }
        }
        
        if(cyclef) {
            return new int[0];
        }
        
        int ans[] = new int[stack.size()];
        for(int i = 0; i < stack.size(); i++) {
            ans[i] = stack.get(i);
        }
        
        return ans;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> gp, int src, boolean[] vis, boolean[] cycle, ArrayList<Integer> stack) {
        vis[src] = true;
        cycle[src] = true;
        
        boolean cyclef = false;
        for(int v : gp.get(src)) {
            if(cycle[v]) {
                return true;
            } else if(!vis[v]) {
                cyclef = cyclef || dfs(gp, v, vis, cycle, stack);
            }
        }
        cycle[src] = false;
        
        if(!cyclef) {
            stack.add(src);
        }
        
        return cyclef;
    }
}