class Solution {
    public void rotate(int[][] matrix) {
        int pushDown = 0;
        int pushRight;
        int temp;
        
        for(int i = 0; i <= (matrix.length/2)-1; i++) {
            pushRight = pushDown;
            for(int j = 0; j < matrix.length-1-(2*pushDown); j++) {
                temp = matrix[matrix.length-1-pushRight][pushDown];
                matrix[matrix.length-1-pushRight][pushDown] = matrix[matrix.length-1-pushDown][matrix.length-1-pushRight];
                matrix[matrix.length-1-pushDown][matrix.length-1-pushRight] = matrix[pushRight][matrix.length-1-pushDown];
                matrix[pushRight][matrix.length-1-pushDown] = matrix[pushDown][pushRight];
                matrix[pushDown][pushRight] = temp;
                pushRight++;
            }
            pushDown++;
        }
    }
}