class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) {
           return image; 
        }
        fill(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    
    private void fill(int[][] image, int sr, int sc, int color, int prev) {
        image[sr][sc] = color;
        
        if(sr > 0 && image[sr - 1][sc] == prev) {
            fill(image, sr - 1, sc, color, prev);
        }
        
        if(sr < image.length - 1 && image[sr + 1][sc] == prev) {
            fill(image, sr + 1, sc, color, prev);
        }
        
        if(sc > 0 && image[sr][sc - 1] == prev) {
            fill(image, sr, sc - 1, color, prev);
        }
        
        if(sc < image[0].length - 1 && image[sr][sc + 1] == prev) {
            fill(image, sr, sc + 1, color, prev);
        }
    }
}