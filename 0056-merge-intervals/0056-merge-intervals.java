class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        ArrayList<Pair> list = new ArrayList<>();
        Pair temp = null;    
        
        for(int[] interval : intervals) {
            pq.add(new Pair(interval[0], interval[1]));
        }
        
        
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            
            if(temp == null) {
                temp = curr;    
            } else {
                if(curr.start <= temp.end) {
                    if(temp.end < curr.end) {
                        temp.end = curr.end;
                    }
                } else {
                    list.add(temp);
                    temp = curr;
                }
            }
        }
        
        list.add(temp);
        int[][] result = new int[list.size()][2];
        
        for(int i = 0; i < result.length; i++) {
            result[i][0] = list.get(i).start;
            result[i][1] = list.get(i).end;
        }
        
        return result;
    }
}

class Pair {
    int start;
    int end;
    
    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}