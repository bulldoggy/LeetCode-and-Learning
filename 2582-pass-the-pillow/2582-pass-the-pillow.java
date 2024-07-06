class Solution {
    public int passThePillow(int n, int time) {
        int iterations = time / (n - 1);
        int remainder = time - ((n - 1) * iterations);
        
        if(iterations % 2 == 0) {
            return 1 + remainder;
        }
        
        return n - remainder;
    }
}