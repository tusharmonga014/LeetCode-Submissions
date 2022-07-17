class Solution {
    private class Pair implements Comparable<Pair> {
        String s;
        int i;
        public Pair(String s, int i) {
            this.s = s;
            this.i = i;
        }
        public int compareTo(Pair o) {
            // System.out.println(this.s + " " + o.s + " " + this.s.compareTo(o.s));
            // if(this.s.compareTo(o.s) < 0) {
            //     return 1;
            // } else if(this.s.compareTo(o.s) >= 0) {
            //     return -1;
            // } else {
            //     return 0;
            // }
            return this.s.compareTo(o.s);
        }
    }
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int ans[] = new int[queries.length];
        for(int q = 0; q < queries.length; q++) {
            int k = queries[q][0];
            int tr = queries[q][1];
            // tr = nums[0].length() % tr;
            // if(tr == nums[0].length()) {
            //     tr = ;
            // }
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            ArrayList<Pair> ars = new ArrayList<>();
            for(int i = 0; i < nums.length; i++) {   
                String s = nums[i].substring(nums[i].length() - tr);
                ars.add(new Pair(s, i));
                // System.out.println(s);
                // if(i < k) {
                //     pq.add(new Pair(s, i));
                // } else {
                //     pq.add(new Pair(s, i));
                //     pq.poll();
                // }
            }
            Collections.sort(ars);
            // Pair rem = pq.poll();
            // System.out.println("rem" + rem.s);
            Pair rem = ars.get(k - 1);
            ans[q] = rem.i;
//             String tn[] = new String[nums.length];
//             for(int i = 0; i < tn.length; i++) {
                
//             }
        }
        return ans;
    }
}