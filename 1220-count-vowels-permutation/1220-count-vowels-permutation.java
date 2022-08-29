class Solution {
    public int countVowelPermutation(int n) {
        long[] dp = new long[] {1, 1, 1, 1, 1};
        long modulo = 1000000007;
        long result = 0;
        
        while(n - 1 > 0) {
            long[] temp = new long[5];
            
            temp[0] = (dp[1] + dp[2] + dp[4]) % modulo;
            temp[1] = (dp[0] + dp[2]) % modulo;
            temp[2] = (dp[1] + dp[3]) % modulo;
            temp[3] = dp[2];
            temp[4] = (dp[2] + dp[3]) % modulo;
            dp = temp;
            n--;
        }
        
        for(long count : dp) {
            result += count;
        }
        result %= modulo;
        
        return (int)result;
    }
}