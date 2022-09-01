class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int left = 0;
        int result = 0;
        
        for(int right = 0; right < s.length(); right++) {
            while(hs.contains(s.charAt(right))) {
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(s.charAt(right));
            if(result < right-left+1) result = right-left+1;
        }
        
        return result;
    }
}