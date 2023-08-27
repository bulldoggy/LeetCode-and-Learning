class Solution {
    public String minWindow(String s, String t) {        
        Map<Character, Integer> hm = new HashMap<>();
        int start = 0;
        int end = -1;
        int count = t.length();
        StringBuilder result = new StringBuilder();
        StringBuilder strStatus = new StringBuilder();
        boolean resultUpdated = false;
                
        for(char c : t.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        
        while(end+1 < s.length() || count <= 0) {
            if(count > 0) {
                end++;
                char cEnd = s.charAt(end);
                if(hm.containsKey(cEnd)) {
                    if(hm.get(cEnd) > 0) {
                        count--;
                    }
                    hm.put(cEnd, hm.get(cEnd) - 1);
                }
                
                strStatus.append(cEnd);
            } else {
                char cStart = s.charAt(start);
                if(hm.containsKey(cStart)) {
                    if(hm.get(cStart) == 0) {
                        count++;
                    }
                    hm.put(cStart, hm.get(cStart) + 1);
                }
                start++;
                
                strStatus.deleteCharAt(0);
            }
            
            if(resultUpdated) {
                if(count <= 0 && strStatus.length() < result.length()) {
                    result = new StringBuilder(strStatus);
                }   
            } else {
                if(count <= 0) {
                    resultUpdated = true;
                    result = new StringBuilder(strStatus);
                }
            }         
        }
        
        return result.toString();
    }
}