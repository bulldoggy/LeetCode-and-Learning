class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        int result = 0;
        
        while(end < s.length()) {
            if(set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            } else {
                set.add(s.charAt(end));
                end++;
                result = Math.max(result, end - start);
            }
        }
        
        return result;
    }
}