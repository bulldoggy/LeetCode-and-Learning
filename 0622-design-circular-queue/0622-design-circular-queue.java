class MyCircularQueue {
    LinkedList<Integer> linkedlist = new LinkedList();
    int size;

    public MyCircularQueue(int k) {
        this.size = k;
    }
    
    public boolean enQueue(int value) {
        if(!isFull()) {
            linkedlist.addLast(value);
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if(!isEmpty()) {
            linkedlist.removeFirst();
            return true;
        }
        return false;
    }
    
    public int Front() {
        if(!isEmpty()) {
            return linkedlist.getFirst();
        }
        return -1;
    }
    
    public int Rear() {
        if(!isEmpty()) {
            return linkedlist.getLast();
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return linkedlist.isEmpty();
    }
    
    public boolean isFull() {
        return linkedlist.size() == size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */