class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;    
        }
        
        HashMap<Character, Integer> hm = new HashMap<>();
        int count = s1.length();
        
        for(int i = 0; i < s1.length(); i++) {
            hm.put(s1.charAt(i), hm.getOrDefault(s1.charAt(i), 0) + 1);
        }
        
        for(int i = 0; i < s1.length(); i++) {
            char in = s2.charAt(i);
            if(hm.containsKey(in)) {
                if(hm.get(in) > 0) {
                    count--;
                }
                hm.put(in, hm.get(in) - 1);
            }
            
            if(count == 0) {
                return true;
            }
        }
        
        for(int i = s1.length(); i < s2.length(); i++) {
            char in = s2.charAt(i);
            if(hm.containsKey(in)) {
                if(hm.get(in) > 0) {
                    count--;
                }
                hm.put(in, hm.get(in) - 1);
            }
            
            char out = s2.charAt(i - s1.length());
            if(hm.containsKey(out)) {
                if(hm.get(out) >= 0) {
                    count++;
                }
                hm.put(out, hm.get(out) + 1);
            }

            if(count == 0) {
                return true;
            }
        }
        
        return false;
    }
}