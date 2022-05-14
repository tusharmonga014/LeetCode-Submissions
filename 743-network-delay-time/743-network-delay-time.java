class Solution {
    private class Edge {
        int v;
        int w;
        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    
    private ArrayList<ArrayList<Edge>> gp;
    
    private void addEdge(int u, int v, int w) {
        this.gp.get(u).add(new Edge(v, w));
    }
    
    private void constructGraph(int[][] arr, int n) {
        this.gp = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            this.gp.add(new ArrayList<>());
        }
        for(int i = 0; i < arr.length; i++) {
            addEdge(arr[i][0], arr[i][1], arr[i][2]);
        }
    }
    
    private void displayGraph() {
        for(int i = 0; i < gp.size(); i++) {
            System.out.print(i + " -> [");
            for(Edge e : gp.get(i)) {
                System.out.print("[" + e.v + "," + e.w + "]");
            }
            System.out.println("]");
        }
    }
    
    private class Pair implements Comparable<Pair> {
        int u;
        int wsf;
        Pair(int u, int wsf) {
            this.u = u;
            this.wsf = wsf;
        }
        public int compareTo(Pair o) {
            return this.wsf - o.wsf; 
        }
    }
    
    private int getMinTime_toTraverseAllNodes(int n, int k) {
        int ans = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(k, 0));
        
        int tvn = 0; // total visited nodes
        boolean vis[] = new boolean[n + 1];
        
        while(tvn < n && !pq.isEmpty()) {
            Pair rem = pq.poll();
        
            if(!vis[rem.u]) {
                
                vis[rem.u] = true;
                tvn++;
                ans = rem.wsf;
            
                for(Edge e : this.gp.get(rem.u)) {
                    pq.offer(new Pair(e.v, e.w + rem.wsf));
                }
                
            }
            
        }
        
        if(tvn < n)
            return -1;
        
        return ans;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        constructGraph(times, n);
        return getMinTime_toTraverseAllNodes(n, k);
    }
}