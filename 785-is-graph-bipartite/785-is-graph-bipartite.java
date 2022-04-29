class Solution {
    public boolean isBipartite(int[][] graph) {
        
//         // two sets
//         HashSet<Integer> s1 = new HashSet<>();
//         HashSet<Integer> s2 = new HashSet<>();
        
//         // queue for bfs
//         LinkedList<Integer> que = new LinkedList<>();
        
//         // for marking visited nodes
//         boolean vis[] = new boolean[graph.length];
        
//         // total nodes visited
//         int tnv = 0;
        
//         s1.add(0);
//         que.addLast(0);
        
//         while(tnv <= graph.length) {
            
//             if(que.isEmpty()) {
//                 for(int i = 0; i < vis.length; i++) {
//                     if(!vis[i]) {
//                         que.addLast(i);
//                         break;
//                     }
//                 }
//             }
            
//             int rem = que.removeFirst();
            
//             vis[rem] = true;
//             tnv++;
            
//             if(s1.contains(rem)) {
//                 for(int i = 0; i < graph[rem].length; i++) {
//                     int v = graph[rem][i];
//                     if(s1.contains(v)) {
//                         return false;  
//                     } else {
//                         if(!vis[v])
//                             que.addLast(v);
//                         s2.add(v);
//                     }
//                 }
//             } else {
//                 for(int i = 0; i < graph[rem].length; i++) {
//                     int v = graph[rem][i];
//                     if(s2.contains(v)) {
//                         return false;  
//                     } else {
//                         if(!vis[v])
//                             que.addLast(v);
//                         s1.add(v);
//                     }
//                 }
//             }
   
//         }
        
//         return true;
        
        s1 = new HashSet<>();
        s2 = new HashSet<>();
        boolean vis[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++) {
            if(!vis[i]) {
                s1.add(i);
                boolean res = dfs(graph, i, vis);
                if(!res) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    HashSet<Integer> s1 = new HashSet<>();
    HashSet<Integer> s2 = new HashSet<>();
    
    public boolean dfs(int[][] graph, int i, boolean[] vis) {
        vis[i] = true;
        if(s1.contains(i)) {
            for(int ni = 0; ni < graph[i].length; ni++) {
                int v = graph[i][ni];
                if(s1.contains(v)) {
                    return false;  
                } else {
                    s2.add(v);
                }
            }
        } else {
            for(int ni = 0; ni < graph[i].length; ni++) {
                int v = graph[i][ni];
                if(s2.contains(v)) {
                    return false;  
                } else {
                    s1.add(v);
                }
            }
        }
        
        for(int ni = 0; ni < graph[i].length; ni++) {
            if(!vis[graph[i][ni]]) {
                boolean res = dfs(graph, graph[i][ni], vis);
                if(!res) {
                    return false;
                }
            }
        }
        
        return true;
    }
}