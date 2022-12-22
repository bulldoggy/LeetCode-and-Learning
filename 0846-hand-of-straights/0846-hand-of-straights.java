class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        if(hand.length % groupSize != 0) return false;
        
        for(int i = 0; i < hand.length; i++) {
            if(hm.containsKey(hand[i])) {
                hm.put(hand[i], hm.get(hand[i])+1);
            } else{
                hm.put(hand[i], 1);
                minHeap.add(hand[i]);
            }
        }
        
        while(!hm.isEmpty()) {           
            while(!hm.containsKey(minHeap.peek())) {
                minHeap.remove();
            }
            
            int curr = minHeap.peek();
            int count = 0;
            
            while(count < groupSize) {
                if(hm.containsKey(curr)) {
                    if(hm.get(curr) == 1) {
                        hm.remove(curr);
                    } else {
                        hm.put(curr, hm.get(curr)-1);
                    }
                    count++;
                    curr++;
                } else {
                    return false;
                }
            }
            count = 0;
        }
        
        return true;
    }
}