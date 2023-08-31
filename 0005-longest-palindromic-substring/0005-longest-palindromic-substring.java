class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1) {
            return s;
        }
        String result = String.valueOf(s.charAt(0));
        int start = 0;
        int end = 0;
        
        for(int i = 1; i < s.length() - 1; i++) {
            start = i - 1;
            end = i + 1;
            
            while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }
            
            start++;
            end--;
            
            if(end - start + 1 > result.length()) {
                result = s.substring(start, end + 1);
            }
            
            start = i - 1;
            end = i;
            
            while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }
            
            start++;
            end--;
            
            if(end - start + 1 > result.length()) {
                result = s.substring(start, end + 1);
            }
        }
        
        if(result.length() < 2 && s.charAt(s.length() - 2) == s.charAt(s.length() - 1)) {
            return s.substring(s.length() - 2, s.length());
        }
        
        return result;
    }
}