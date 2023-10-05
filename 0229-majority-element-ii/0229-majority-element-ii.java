class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int num : nums) {
            if(hm.size() < 2 || hm.containsKey(num)) {
                hm.put(num, hm.getOrDefault(num, 0) + 1);
            } else {
                List<Integer> keys = new ArrayList<>();
                
                for(Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                    keys.add(entry.getKey());    
                }
                
                for(int key : keys) {
                    if(hm.get(key) > 1) {
                        hm.put(key, hm.get(key) - 1);
                    } else {
                        hm.remove(key);
                    }
                }
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int count = 0;
            int key = entry.getKey();
            
            for(int num : nums) {
                if(num == key) {
                    count++;
                }    
            }
            
            if(count > nums.length / 3) {
                result.add(key);
            }
        }
        
        return result;
    }
}