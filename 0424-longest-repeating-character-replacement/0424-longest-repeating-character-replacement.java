class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> hm = new HashMap<>();
        int maxFreq = 0;
        int start = 0;
        int end = -1;
        int result = 0;
        
        while(end < s.length() - 1) {
            int swopped = end - start + 1 - maxFreq;
            
            if(swopped <= k) {
                end++;
                char cEnd = s.charAt(end);
                hm.put(cEnd, hm.getOrDefault(cEnd, 0) + 1);
                
                if(hm.get(cEnd) > maxFreq) {
                    maxFreq = hm.get(cEnd);
                }
            } else {
                while(swopped > k) {
                    char cStart = s.charAt(start);
                    hm.put(cStart, hm.get(cStart) - 1);
                    start++;
                    swopped = end - start + 1 - maxFreq;
                }
            }
            
            if(end - start + 1 - maxFreq <= k && end - start + 1 > result) {
                result = end - start + 1;
            }
            
            //System.out.println("len: " + (end - start + 1) + ", start: " + start + ", maxFreq: " + maxFreq);
        }
        
        return result;
    }
}