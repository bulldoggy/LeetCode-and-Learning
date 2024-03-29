class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        int offset = 1;
        
        for(int i = 1; i <= n; i++) {
            if(i == offset*2) offset = i;
            result[i] = result[i-offset] + 1;
        }
        return result;
    }
}