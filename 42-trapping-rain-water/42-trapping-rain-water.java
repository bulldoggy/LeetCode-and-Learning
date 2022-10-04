class Solution {
    public int trap(int[] height) {
        int result = 0;
        int leftMax = 0;
        int rightMax = 0;
        int leftPointer = 0;
        int rightPointer = height.length-1;
        
        while(leftPointer + 1 < rightPointer) {
            if(height[leftPointer] <= height[rightPointer]) {
                if(leftMax < height[leftPointer]) leftMax = height[leftPointer];
                leftPointer++;
                result += Math.max(0, leftMax-height[leftPointer]);
            } else {
                if(rightMax < height[rightPointer]) rightMax = height[rightPointer];
                rightPointer--;
                result += Math.max(0, rightMax-height[rightPointer]);
            }
        }
        
        return result;
    }
}