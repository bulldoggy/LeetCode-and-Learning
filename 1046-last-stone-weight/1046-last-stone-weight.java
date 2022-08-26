class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int first, second = 0;
        
        for(int stone : stones) {
            pq.add(stone);
        }
        
        while(!pq.isEmpty()) {
            first = pq.poll();
            if(pq.peek() == null) {
                return first;
            }
            second = pq.poll();
            if(!(first == second)) pq.add(Math.abs(first - second));
        }
        return 0;
    }
}