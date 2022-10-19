class Solution {
    class Pair implements Comparable<Pair> {
        int val;
        int x;
        int y;
        Pair(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i = 0; i < matrix.length; i++) {
            pq.offer(new Pair(matrix[i][0], i, 0));
        }
        
        while(k-- > 1) {
            Pair rem = pq.poll();
            if(rem.y < matrix[rem.x].length - 1) {
                pq.offer(new Pair(matrix[rem.x][rem.y + 1], rem.x, rem.y + 1));
            }
        }
        
        return pq.peek().val;
    }
}