class Solution {
    class Pair implements Comparable<Pair> {
        int v;
        int i;
        int j;
        Pair(int v, int i, int j) {
            this.v = v;
            this.i = i;
            this.j = j;
        }
        public int compareTo(Pair o) {
            return this.v - o.v;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            pq.add(new Pair(matrix[i][0], i, 0));
        }
        while(k-- > 0) {
            Pair rem = pq.poll();
            if(k == 0) return rem.v;
            else if(rem.j != matrix[rem.i].length - 1) {
                pq.offer(new Pair(matrix[rem.i][rem.j + 1], rem.i, rem.j + 1));
            }
        }
        return -1;
    }
}