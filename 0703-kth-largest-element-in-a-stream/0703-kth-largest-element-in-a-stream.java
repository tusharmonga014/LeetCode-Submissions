class KthLargest {
    
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        for(int ele : nums) {
            this.pq.offer(ele);
            if(this.pq.size() > this.k) {
                this.pq.poll();
            }
        }
    }
    
    public int add(int val) {
        this.pq.offer(val);
        
        if(this.pq.size() > this.k) this.pq.poll();
        
        return this.pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */