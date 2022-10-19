class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele : nums) {
            pq.offer(ele);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}