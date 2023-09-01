class MyStack {
    private Queue<Integer> queue = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        queue.offer(x);
    }
    
    public int pop() {
        for(int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
        return queue.poll();
    }
    
    public int top() {
        int val = 0;
        for(int i = 0; i < queue.size(); i++) {
            val = queue.poll();
            queue.offer(val);
        }
        return val;
    }
    
    public boolean empty() {
        return queue.isEmpty();
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