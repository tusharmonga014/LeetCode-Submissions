class Solution {
    class Edge implements Comparable<Edge> {
        public int src, end, weight;
        public Edge(int src, int end, int weight) {
            this.src = src;
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    class UnionFind {
        class subset {
            public int parent, rank;
        }

        private final subset[] subsets;
        public UnionFind(int length) {
            subsets = new subset[length];
            for (int i = 0; i < length; ++i) {
                subsets[i] = new subset();
                subsets[i].parent = i;
                subsets[i].rank = 0;
            }
        }

        int find(int i) {
            if (subsets[i].parent != i)
                subsets[i].parent = find(subsets[i].parent);

            return subsets[i].parent;
        }

        void union(int x, int y)
        {
            int xroot = find(x);
            int yroot = find(y);

            if (subsets[xroot].rank < subsets[yroot].rank)
                subsets[xroot].parent = yroot;
            else if (subsets[xroot].rank > subsets[yroot].rank)
                subsets[yroot].parent = xroot;
            else {
                subsets[yroot].parent = xroot;
                subsets[xroot].rank++;
            }
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int length = points.length * (points.length - 1) / 2;       // Build all edges. Total there will be nC2 edges. That is n * (n - 1) / 2
        Edge[] edge = new Edge[length];

        int idx = 0;
        for(int i = 0; i < points.length - 1; i++) {
            for(int j = i + 1; j < points.length; j++) {
                int weight = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
                edge[idx++] = new Edge(i, j, weight);
            }
        }

        Arrays.sort(edge);

        UnionFind unionFind = new UnionFind(points.length);         // Use UnionFind to check if newly picked edge creates a loop

        idx = 0;
        int totalEdges = 0;
        int result = 0;
        while(totalEdges < points.length - 1) {
            Edge next = edge[idx++];

            int x = unionFind.find(next.src);
            int y = unionFind.find(next.end);

            if (x != y) {                   // If this edge does not create a loop, add this edge weight to result
                result += next.weight;
                unionFind.union(x, y);
                totalEdges++;
            }
        }
        return result;
    }
}