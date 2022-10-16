class Solution {
    public int kthGrammar(int n, int k) {
        int level = 1;
        int curr = 0;
        int length = (int)Math.pow(2, n-1);
            
        while(level < n) {
            if(k > length/2) {
                curr = shiftRight(curr);
                k -= length/2;
                length /= 2;
            } else  {
                curr = shiftLeft(curr);
                length /= 2;
            }
            level++;
        }
        return curr;
    }
    
    private int shiftRight(int curr) {
        if(curr == 0) {
            return 1;
        }
        return 0;
    }
    
    private int shiftLeft(int curr) {
        if(curr == 0) {
            return 0;
        }
        return 1;
    }
}