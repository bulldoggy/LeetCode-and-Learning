class Solution {
    public int shortestBridge(int[][] grid) {
        Queue<Pair> store = new LinkedList<>();
        Queue<Pair> bfs = new LinkedList<>();
        boolean found = false;
        int distance = 0;
        int inQueue = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    Pair pair = new Pair(i, j);
                    store.add(pair);
                    bfs.add(pair);
                    grid[i][j] = 2;
                    break;
                }
            }
           
            if(!bfs.isEmpty()) {
                break;
            }
        }
        
        while(!bfs.isEmpty()) {
            Pair p = bfs.poll();
            
            if(p.y-1 >= 0 && grid[p.x][p.y-1] == 1) {
                Pair pair = new Pair(p.x, p.y-1);
                store.add(pair);
                bfs.add(pair);
                grid[p.x][p.y-1] = 2;
            } 
            
            if(p.y+1 < grid[0].length && grid[p.x][p.y+1] == 1) {
                Pair pair = new Pair(p.x, p.y+1);
                store.add(pair);
                bfs.add(pair);
                grid[p.x][p.y+1] = 2;
            }
            
            if(p.x-1 >= 0 && grid[p.x-1][p.y] == 1) {
                Pair pair = new Pair(p.x-1, p.y);
                store.add(pair);
                bfs.add(pair);
                grid[p.x-1][p.y] = 2;
            }
            
            if(p.x+1 < grid.length && grid[p.x+1][p.y] == 1) {
                Pair pair = new Pair(p.x+1, p.y);
                store.add(pair);
                bfs.add(pair);
                grid[p.x+1][p.y] = 2;
            }
        }
        
        
        while(true) {
            inQueue = store.size();
            
            for(int i = 0; i < inQueue; i++) {
                Pair p = store.poll();
            
                if(p.y-1 >= 0 && grid[p.x][p.y-1] == 0) {
                    Pair pair = new Pair(p.x, p.y-1);
                    store.add(pair);
                    grid[p.x][p.y-1] = 2;
                } else if(p.y-1 >= 0 && grid[p.x][p.y-1] == 1) {
                    return distance;
                } 
                
                if(p.y+1 < grid[0].length && grid[p.x][p.y+1] == 0) {
                    Pair pair = new Pair(p.x, p.y+1);
                    store.add(pair);
                    grid[p.x][p.y+1] = 2;
                } else if(p.y+1 < grid[0].length && grid[p.x][p.y+1] == 1) {
                    return distance;
                }
                
                if(p.x-1 >= 0 && grid[p.x-1][p.y] == 0) {
                    Pair pair = new Pair(p.x-1, p.y);
                    store.add(pair);
                    grid[p.x-1][p.y] = 2;
                } else if(p.x-1 >= 0 && grid[p.x-1][p.y] == 1) {
                    return distance;
                }
                
                if(p.x+1 < grid.length && grid[p.x+1][p.y] == 0) {
                    Pair pair = new Pair(p.x+1, p.y);
                    store.add(pair);
                    grid[p.x+1][p.y] = 2;
                } else if(p.x+1 < grid.length && grid[p.x+1][p.y] == 1) {
                    return distance;
                }
            }
            
            distance++;
        }
    }
}

class Pair {
    public int x;
    public int y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}