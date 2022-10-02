class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int start = 0;
        int end = height.length-1;
        
        while(start < end) {
            int currArea = getArea(start, end, height);
            if(currArea > result) result = currArea;
            if(height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }
        
        return result;
    }
    
    private int getArea(int start, int end, int[] height) {
        return Math.min(height[start], height[end]) * (end-start);
    }
}