class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> hm = new HashMap<>();
        int count = ransomNote.length();
        
        for(char c : ransomNote.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        
        for(char c : magazine.toCharArray()) {
             if(hm.containsKey(c)) {
                 if(hm.get(c) > 0) {
                     count--;
                 }
                 hm.put(c, hm.get(c) - 1);
             }
            
            if(count <= 0) {
                return true;
            }
        }
        
        return false;
    }
}