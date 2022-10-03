class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxFreq = 0;
        int result = 0;
        
        while(end < s.length()) {
            char c = s.charAt(end);
            if(hm.get(c) == null) {
                hm.put(c, 1);
            } else {
                hm.put(c, hm.get(c)+1);
            }
            if(hm.get(c) > maxFreq) maxFreq = hm.get(c);
            
            if((end-start+1) - maxFreq <= k) {
                if((end-start+1) > result) result = end - start + 1;
            } else {
                while((end-start+1) - maxFreq > k) {
                    hm.put(s.charAt(start), hm.get(s.charAt(start))-1);
                    start++;
                    maxFreq = findMaxFreq(hm);
                }
            }
            end++;
        }
        return result;
    }
    
    private int findMaxFreq(HashMap<Character, Integer> hm) {
        int max = 0;
        if(hm.values() != null) {
            for(int i : hm.values()) {
                if(i > max) max = i;
            }
        }
        return max;
    }
}