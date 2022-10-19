class Solution {
    class gPair implements Comparable<gPair> {
        int x;
        int y;
        double d;
        gPair(int x, int y, double d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
        public int compareTo(gPair o) {
            if(this.d < o.d) {
                return 1;
            } else {
                return -1;
            }
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int ans[][] = new int[k][2];
        
        PriorityQueue<gPair> pq = new PriorityQueue<>();
        for(int point[] : points) {
            int x = point[0];
            int y = point[1];
            double thisd = Math.sqrt((x * x) + (y * y));
            pq.offer(new gPair(point[0], point[1], thisd));
            if(pq.size() > k) {
                pq.poll();
            }
        }
        
        int idx = 0;
        while(pq.size() != 0) {
            gPair rem = pq.poll();
            ans[idx][0] = rem.x;
            ans[idx][1] = rem.y;
            
            idx++;
        }
        
        return ans;
    }
}