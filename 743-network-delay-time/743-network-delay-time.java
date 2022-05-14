class Solution {
    public int networkDelayTime(int[][] times, int n, int K) {
        int[][] graph = new int[n][n];
        for(int i = 0; i < n ; i++) Arrays.fill(graph[i], Integer.MAX_VALUE);
        for( int[] rows : times) graph[rows[0] - 1][rows[1] - 1] =  rows[2];        
        
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K - 1] = 0;
        
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n ; i++){
            int v = minIndex(distance, visited);
            if(v == -1)continue;
            visited[v] = true;
            for(int j = 0; j < n; j++){
                if(graph[v][j] != Integer.MAX_VALUE){
                    int newDist = graph[v][j] + distance[v];
                    if(newDist < distance[j]) distance[j] = newDist;
                }
            }
        }
        int result = 0;
        for(int dist : distance){
            if(dist == Integer.MAX_VALUE) return -1;
            result = Math.max(result, dist);
        }
        return result;
    }
	
    private int minIndex(int[] distance, boolean[] visited){
        int min = Integer.MAX_VALUE, minIndex = -1;
        for(int i = 0; i < distance.length; i++){
            if(!visited[i] && distance[i] < min){
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}







// class Solution {
//     private class Edge {
//         int v;
//         int w;
//         Edge(int v, int w) {
//             this.v = v;
//             this.w = w;
//         }
//     }
    
//     private ArrayList<ArrayList<Edge>> gp;
    
//     private void addEdge(int u, int v, int w) {
//         this.gp.get(u).add(new Edge(v, w));
//     }
    
//     private void constructGraph(int[][] arr, int n) {
//         this.gp = new ArrayList<>();
//         for(int i = 0; i <= n; i++) {
//             this.gp.add(new ArrayList<>());
//         }
//         for(int i = 0; i < arr.length; i++) {
//             addEdge(arr[i][0], arr[i][1], arr[i][2]);
//         }
//     }
    
//     private void displayGraph() {
//         for(int i = 0; i < gp.size(); i++) {
//             System.out.print(i + " -> [");
//             for(Edge e : gp.get(i)) {
//                 System.out.print("[" + e.v + "," + e.w + "]");
//             }
//             System.out.println("]");
//         }
//     }
    
//     private class Pair implements Comparable<Pair> {
//         int u;
//         int wsf;
//         Pair(int u, int wsf) {
//             this.u = u;
//             this.wsf = wsf;
//         }
//         public int compareTo(Pair o) {
//             return this.wsf - o.wsf; 
//         }
//     }
    
//     private int getMinTime_toTraverseAllNodes(int n, int k) {
//         int ans = 0;
        
//         PriorityQueue<Pair> pq = new PriorityQueue<>();
//         pq.offer(new Pair(k, 0));
        
//         int tvn = 0; // total visited nodes
//         boolean vis[] = new boolean[n + 1];
        
//         while(tvn < n && !pq.isEmpty()) {
//             Pair rem = pq.poll();
        
//             if(!vis[rem.u]) {
                
//                 vis[rem.u] = true;
//                 tvn++;
//                 ans = rem.wsf;
            
//                 for(Edge e : this.gp.get(rem.u)) {
//                     pq.offer(new Pair(e.v, e.w + rem.wsf));
//                 }
                
//             }
            
//         }
        
//         if(tvn < n)
//             return -1;
        
//         return ans;
//     }

//     public int networkDelayTime(int[][] times, int n, int k) {
//         constructGraph(times, n);
//         return getMinTime_toTraverseAllNodes(n, k);
//     }
// }