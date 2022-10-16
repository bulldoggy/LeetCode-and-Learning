class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        
        dp[dp.length-1] =  true;
        for(int i = s.length()-1; i >= 0; i--) {
            for(String word : wordDict) {
                if(s.length()-i >= word.length() && match(i, s, word)) {
                    dp[i] = dp[i+word.length()];
                    if(dp[i]) {
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
    
    private boolean match(int index, String s, String word) {
        for(int i = 0; i < word.length(); i++) {
            if(s.charAt(index+i) != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}