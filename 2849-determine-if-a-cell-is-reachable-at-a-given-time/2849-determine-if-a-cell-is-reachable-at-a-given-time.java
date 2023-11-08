class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(sx == fx && sy == fy && t == 1) return false;
        
        int stepX = Math.abs(sx - fx);
        int stepY = Math.abs(sy - fy);
        int minStep = Math.max(stepX, stepY);
        
        return t >= minStep;
    }
}