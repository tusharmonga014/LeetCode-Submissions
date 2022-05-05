class MyStack {

    LinkedList<Integer> que;
    
    public MyStack() {
        this.que = new LinkedList<>();
    }
    
    public void push(int x) {
        this.que.addLast(x);   
    }
    
    public int pop() {
        LinkedList<Integer> que2 = new LinkedList<>();
        int n = this.que.size();
        while(this.que.size() > 0) {
            if(n == 1) {
                int val = this.que.removeFirst();
                this.que = que2;
                return val;
            }
            que2.addLast(this.que.removeFirst());
            n--;
        }
        return -1;
    }
    
    public int top() {
        LinkedList<Integer> que2 = new LinkedList<>();
        int n = this.que.size();
        while(this.que.size() > 0) {
            if(n == 1) {
                int val = this.que.getFirst();
                que2.addLast(val);
                this.que = que2;
                return val;
            }
            que2.addLast(this.que.removeFirst());
            n--;
        }
        return -1;
    }
    
    public boolean empty() {
        return que.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */