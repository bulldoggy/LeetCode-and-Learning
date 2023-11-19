class Solution {
    public int reductionOperations(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for(int num : nums) {
            if(!hm.containsKey(num)) {
                pq.add(num);
            }
            
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        
        int count = 0;
        int result = 0;
        
        while(pq.size() > 1) {
            count += hm.get(pq.poll());
            result += count;
        }
        
        return result;
    }
}