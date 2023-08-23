class Solution {
    public void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix.length - 1;
        
        while(left < right) {
            for(int i = 0; i < right - left; i++) {
                int top = left;
                int bottom = right;
                int topLeft = matrix[top][left+i];
                
                //top-left < bottom-left
                matrix[top][left+i] = matrix[bottom-i][left]; 
                
                //bottom-left < bottom-right
                matrix[bottom-i][left] = matrix[bottom][right-i];
                
                //bottom-right < top-right
                matrix[bottom][right-i] = matrix[top+i][right];
                    
                //top-right < topLeft
                matrix[top+i][right] = topLeft;
            }
            
            
            left++;
            right--;
        }
    }
}