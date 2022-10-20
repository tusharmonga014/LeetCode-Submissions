class MedianFinder {
    PriorityQueue<Integer> maxH;
    PriorityQueue<Integer> minH;
    
    public MedianFinder() {
        maxH = new PriorityQueue<>(Collections.reverseOrder());
        minH = new PriorityQueue<>();
    }
    
    private void equalizePQs() {
       
        while(maxH.size() > minH.size() + 1) {
            minH.offer(maxH.poll());
        }
        
        while(minH.size() > maxH.size()) {
            maxH.offer(minH.poll());
        }
        
    }

    public void addNum(int num) {
        
        if(maxH.size() == 0) {
            maxH.offer(num);
        } else if(num <= maxH.peek()) {
            maxH.offer(num);
        } else {
            minH.offer(num);
        }
        
        equalizePQs();
    }
    
    public double findMedian() {
        if(minH.size() == maxH.size()) {
            return ((minH.peek() + maxH.peek()) * 1.0) / 2.0;
        } else {
            return maxH.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */