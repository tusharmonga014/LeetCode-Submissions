class Solution {
    class rPair implements Comparable<rPair> {
        int val;
        int i;
        int j;
        rPair(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }
        public int compareTo(rPair o) {
            return this.val - o.val;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<rPair> minH = new PriorityQueue<>();
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); i++) {
            int ele = nums.get(i).get(0);
            minH.add(new rPair(ele, i, 0));
            max = Math.max(max, ele);
        }
        
        int range = Integer.MAX_VALUE;
        int ans[] = new int[2];
        
        while(minH.size() == nums.size()) {
            rPair min = minH.poll();
            int cur_range = max - min.val;
            if(cur_range < range) {
                range = cur_range;
                ans[0] = min.val;
                ans[1] = max;
            }
            
            if(min.j < nums.get(min.i).size() - 1) {
                int ele = nums.get(min.i).get(min.j + 1);
                minH.offer(new rPair(ele, min.i, min.j + 1));
                max = Math.max(max, ele);
            } else {
                break;
            }
        }
        
        return ans;
    }
}