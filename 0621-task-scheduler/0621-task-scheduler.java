class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        Queue<Pair> queue = new LinkedList<>();
        HashMap<Character, Integer> hm = new HashMap<>();
        int time = 0;
        
        for(char c : tasks) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        
        System.out.println(hm.toString());
        
        for(int val : hm.values()) {
            pq.offer(new Pair(val, 0));
        }
        
        while(!(pq.isEmpty() && queue.isEmpty())) {
            if(!pq.isEmpty()) {
                Pair curr = pq.poll();
                curr.count--;

                if(curr.count > 0) {
                    curr.nextAvail = time + n;
                    queue.offer(curr);
                }
            }
            
            if(!queue.isEmpty() && queue.peek().nextAvail <= time) {
                pq.offer(queue.poll());
            }
            
            time++;
        }
        
        return time;
    }
}

class Pair {
    int count;
    int nextAvail;
    
    public Pair(int count, int nextAvail) {
        this.count = count;
        this.nextAvail = nextAvail;
    }
}