class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        return isIso(s, t) && isIso(t,s);
    }
    
    private boolean isIso(String s, String t) {
        Map<Character, List<Integer>> hm = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(hm.containsKey(c)) {
                hm.get(c).add(i);    
            } else {
                List<Integer> list = new ArrayList<>();
                
                list.add(i);
                hm.put(c, list);
            }
        }
        
        for(Map.Entry<Character, List<Integer>> entrySet : hm.entrySet()) {
            if(!allPosSameChar(entrySet.getValue(), t)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean allPosSameChar(List<Integer> list, String s) {
        char c = s.charAt(list.get(0));
        
        for(int i = 1; i < list.size(); i++) {
            if(s.charAt(list.get(i)) != c) {
                return false;
            }
        }
        
        return true;
    }
}