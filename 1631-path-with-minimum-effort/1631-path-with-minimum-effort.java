class Solution {
    
    public class Edge implements Comparable<Edge> {
        int v;
        int w;
        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
    
    ArrayList<ArrayList<Edge>> gp;
    
    int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        int n = r * c;
        
        if(n == 1) {
            return 0;
        }
        
        // build graph
        buildGraph(heights);
                
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[n];
        
        int max = Integer.MIN_VALUE;
        
        vis[0] = true;
        for(Edge e : gp.get(0)) {
            // vis[e.v] = true;
            pq.offer(e);
        }
        
        while(!pq.isEmpty()) {
            Edge rem = pq.poll();
            
            max = Math.max(max, rem.w);
            
            vis[rem.v] = true;
            
            if(rem.v == n - 1) {
                return max;
            }
            
            for(Edge e : gp.get(rem.v)) {
                if(!vis[e.v]) {
                    pq.offer(e);
                }
            }
        }
        
        return max;
    }
    
    public void buildGraph(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        int n = r * c;
        
        gp = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            gp.add(new ArrayList<>());
        }
        for(int i = 0; i < heights.length; i++) {
            for(int j = 0; j < heights[0].length; j++) {
                for(int d = 0; d < dir.length; d++) {
                    int x = i + dir[d][0];
                    int y = j + dir[d][1];
                    if(x >= 0 && y >= 0 && x < r && y < c) {
                        int idx = (i * c) + j;
                        int toMoveIdx = (x * c) + y;
                        gp.get(idx).add(new Edge(toMoveIdx, Math.abs(heights[i][j] - heights[x][y])));
                    }
                }
            }
        }
    }
}