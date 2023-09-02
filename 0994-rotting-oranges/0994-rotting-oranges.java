class Solution {
    int result = 0;
    
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        HashSet<Pair> hs = new HashSet<>();
        
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == 2) {
                    grid[row][col] = 3;
                    Pair p = new Pair(row, col, 0);
                    hs.add(p);
                    queue.offer(p);
                    grid[row][col] = 3;
                }
            }
        }
        
        while(!queue.isEmpty()) {
            Pair curr = queue.poll();
            int row = curr.row;
            int col = curr.col;
            if(row > 0 && grid[row - 1][col] == 1) {
                Pair p = new Pair(row - 1, col, curr.min + 1);
                if(!hs.contains(p)) {
                    queue.offer(p);
                    hs.add(p);
                }
                grid[row - 1][col] = 3;
            }
            
            if(row < grid.length - 1 && grid[row + 1][col] == 1) {
                Pair p = new Pair(row + 1, col, curr.min + 1);
                if(!hs.contains(p)) {
                    queue.offer(p);
                    hs.add(p);
                }
                grid[row + 1][col] = 3;
            }
            
            if(col > 0 && grid[row][col - 1] == 1) {
                Pair p = new Pair(row, col - 1, curr.min + 1);
                if(!hs.contains(p)) {
                    queue.offer(p);
                    hs.add(p);
                }
                grid[row][col - 1] = 3;
            }
            
            if(col < grid[0].length - 1 && grid[row][col + 1] == 1) {
                Pair p = new Pair(row, col + 1, curr.min + 1);
                if(!hs.contains(p)) {
                    queue.offer(p);
                    hs.add(p);
                }
                grid[row][col + 1] = 3;
            }
            
            if(curr.min > result) {
                result = curr.min;
            }
        }
        
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == 1) {
                    return -1;
                }
            }
        }
        
        return result;
    }
}

class Pair {
    int row;
    int col;
    int min;
    
    public Pair(int row, int col, int min) {
        this.row = row;
        this.col = col;
        this.min = min;
    }
    
    @Override
    public int hashCode()
    {
        return Integer.valueOf(String.valueOf(this.row) + String.valueOf(this.col));
    }
}