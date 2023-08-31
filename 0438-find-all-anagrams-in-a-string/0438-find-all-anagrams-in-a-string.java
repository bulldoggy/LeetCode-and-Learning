class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> hm = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int count = p.length();
        int end = 0;
        
        for(char c : p.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        
        while(end < s.length()) {
            char endChar = s.charAt(end);
            
            if(hm.containsKey(endChar)) {
                if(hm.get(endChar) > 0) {
                    count--;
                }
                hm.put(endChar, hm.get(endChar) - 1);
            }
            
            if(end >= p.length()) {
                char startChar = s.charAt(end - p.length());
                if(hm.containsKey(startChar)) {
                    if(hm.get(startChar) >= 0) {
                        count++;
                    }
                    hm.put(startChar, hm.get(startChar) + 1);
                }
            }
            
            end++;
            
            if(count == 0) {
                result.add(end - p.length());
            }          
        }
        
        return result;
    }
}