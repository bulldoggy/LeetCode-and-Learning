class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> hs = new HashSet<>();
        int result = 0;
        
        for(char c : s.toCharArray()) {
            if(hs.contains(c)) {
                hs.remove(c);
                result += 2;
            } else {
                hs.add(c);
            }
        }
        
        if(hs.isEmpty()) {
            return result;
        } 
        return result + 1;
    }
}