class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), i);
        }
        
        int i = 0; 
        int j = 0;
    
        while(i < s.length()) {
            int count = 0;
            j = Math.max(j, hm.get(s.charAt(i)));
            
            while(i <= j) {
                j = Math.max(j, hm.get(s.charAt(i)));
                count++;
                i++;
            }
            result.add(count);
        }
        
        return result;
    }
}