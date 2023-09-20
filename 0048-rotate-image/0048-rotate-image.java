class Solution {
    public void rotate(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        
        while(top < bottom) {
            for(int i = 0; i < bottom - top; i++) {
                int left = top;
                int right = bottom;
                int topLeft = matrix[top][left + i];
                
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = topLeft;
            }
            
            top++;
            bottom--;
        }
    }
}