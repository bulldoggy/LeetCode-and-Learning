class Solution {
    public int longestStrChain(String[] words) {
        int[] dp = new int[words.length];
        int result = 0;
        
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for(int i = 1; i < words.length; i++) {
            for(int j = 0; j < i; j++) {
                if(isPred(words[j], words[i])) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    result = Math.max(result, dp[i]);
                }
            }
        }
                
        return result + 1;
    }
    
    private boolean isPred(String a, String b) {
        if(a.length() + 1 != b.length()) {
            return false;
        }
        
        int aPtr = 0;
        int bPtr = 0;
        
        while(aPtr < a.length() && bPtr < b.length()) {
            if(a.charAt(aPtr) == b.charAt(bPtr)) {
                aPtr++;
                bPtr++;
            } else {
                bPtr++;
            }
        }
        
        if(aPtr + 1 == bPtr || aPtr == bPtr) {
            return true;
        }
        
        return false;
    }
}