class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> gp = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            gp.add(new ArrayList<>());
        
        int inDegree[] = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            gp.get(u).add(v);
            inDegree[v]++;
        }
        
        Queue<Integer> que = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0)
                que.add(i);
        }
        
        int ans[] = new int[numCourses];
        int idx = 0;
        while(que.size() > 0) {
            int s = que.poll();
            for(int v : gp.get(s)) {
                inDegree[v]--;
                if(inDegree[v] == 0)
                    que.add(v);
            }
            ans[idx] = s;
            idx++;
        }
        
        if(idx < numCourses) {
            return new int[0];
        }
        
        return ans;
    }
}