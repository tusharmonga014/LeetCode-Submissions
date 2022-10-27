class MinStack {
    
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
        min = 0;
    }
    
    public void push(int val) {
        if(st.size() == 0) {
            st.push((long)val);
            min = val;
        } else if(val >= min) {
            st.push((long)val);
        } else {
            st.push(((long)(val + (long)val) - min));
            min = val;
        }
    }
    
    public void pop() {
        if(st.size() == 0) return;
        else {
            if(st.peek() >= min) {
                st.pop();
            } else {
                min = (2 * min) - st.peek();
                st.pop();
            }
        }
        
    }
    
    public int top() {
        if(st.size() == 0) return -1;
        else {
            if(st.peek() >= min) {
                return (int)(long)st.peek();
            } else {
                return (int)(long)min;
            }
        }
    }
    
    public int getMin() {
        return (int)(long)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */