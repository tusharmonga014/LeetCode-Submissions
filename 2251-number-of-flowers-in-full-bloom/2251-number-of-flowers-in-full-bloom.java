class Solution {
    public class Pair implements Comparable<Pair> {
        int v;
        int i;
        int c; // category -> 0->s, 1->p, 2->e
        Pair(int v, int i, int c) {
            this.v = v;
            this.i = i;
            this.c = c;
        }
        public int compareTo(Pair o) {
            if(this.v < o.v) {
                return -1;
            } else if(this.v > o.v) {
                return 1;
            } else {
                if(this.c < o.c) {
                    return -1;
                } else if(this.c > o.c) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int maxPersonArrival = Integer.MIN_VALUE;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < persons.length; i++) {
            pq.add(new Pair(persons[i], i, 1));
            maxPersonArrival = Math.max(maxPersonArrival, persons[i]);
        }
        for(int i = 0; i < flowers.length; i++) {
            pq.add(new Pair(flowers[i][0], i, 0));
            pq.add(new Pair(flowers[i][1], i, 2));
        }
        
        int curr = 0;
        int ans[] = new int[persons.length];
        
        while(pq.size() > 0) {
            Pair rem = pq.poll();
            if(rem.c == 0) {
                curr++;
            } else if(rem.c == 1) {
                ans[rem.i] = curr;
            } else {
                curr--;
            }
        }
        
        return ans;
    }
}