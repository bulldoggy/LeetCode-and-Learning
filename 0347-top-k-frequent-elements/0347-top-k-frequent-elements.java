class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> bucket = new ArrayList<>();
        Map<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i <= nums.length; i++) {
            bucket.add(new ArrayList<>());
        }
        
        for(int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> map : hm.entrySet()) {
            bucket.get(map.getValue()).add(map.getKey());
        }
        
        int[] res = new int[k];
        int resPtr = 0;
        int pos = bucket.size()-1;
        
        while(resPtr < res.length) {
            if(bucket.get(pos).size() != 0) {
                for(Integer num : bucket.get(pos)) {
                    res[resPtr] = num;
                    resPtr++;
                }
            }    
            
            pos--;
        }
        
        return res;
    }
}