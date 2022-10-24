class MedianFinder {

    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;
    
    public MedianFinder() {
        pq1 = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        pq2 = new PriorityQueue<>();
    }
    
    private void equalizePQs() {
        if(pq2.size() > pq1.size()) {
            pq1.add(pq2.poll());
        }
        if(pq1.size() > pq2.size() + 1) {
            pq2.add(pq1.poll());
        }
    }
    
    public void addNum(int num) {
        if(pq1.size() == 0) {
            pq1.add(num);
        } else  if(pq1.peek() >= num) {
            pq1.add(num);
        } else {
            pq2.add(num);
        }
        
        equalizePQs();
    }
    
    public double findMedian() {
        if(pq1.size() == pq2.size()) {
            return (pq1.peek() + pq2.peek()) / 2.0;
        } else {
            return pq1.peek() * 1.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */