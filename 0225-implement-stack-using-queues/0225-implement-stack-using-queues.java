class MyStack {
    Queue<Integer> queue;
    int numOfElem;
    
    public MyStack() {
        this.queue = new LinkedList<>();
        numOfElem = 0;
    }
    
    public void push(int x) {
        this.queue.offer(x);
        numOfElem++;
    }
    
    public int pop() {
        int num = numOfElem;
        
        while(num > 1) {
            this.queue.offer(this.queue.poll());
            num--;
        }
        
        numOfElem--;
        return this.queue.poll();
    }
    
    public int top() {
        int num = numOfElem;
        
        while(num > 1) {
            this.queue.offer(this.queue.poll());
            num--;
        }
        
        int res = this.queue.peek();
        this.queue.offer(this.queue.poll());
        
        return res;
    }
    
    public boolean empty() {
        return numOfElem == 0;
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