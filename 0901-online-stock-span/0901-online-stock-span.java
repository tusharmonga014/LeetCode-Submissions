class StockSpanner {
    
    Stack<Integer[]> st;

    public StockSpanner() {
        this.st = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;
        while(!this.st.isEmpty() && st.peek()[0] <= price) {
            count += st.pop()[1];
        }
        st.push(new Integer[]{price, count});
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */