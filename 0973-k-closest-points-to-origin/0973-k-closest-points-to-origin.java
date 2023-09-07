class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        HashMap<Integer, List<int[]>> hm = new HashMap<>();

        
        for(int[] point : points) {
            int dist = (int) Math.pow(point[0], 2) + (int) Math.pow(point[1], 2);
            
            if(hm.containsKey(dist)) {
                List<int[]> list = hm.get(dist);
                list.add(point);
                hm.put(dist, list);
            } else {
                List<int[]> list = new ArrayList<>();
                list.add(point);
                hm.put(dist, list);
                pq.add(dist);
            }
        }
        
        int[][] result = new int[k][2];
        int pos = 0;
        
        while(pos < k) {
            int dist = pq.poll();
            List<int[]> list = hm.get(dist);
            
            for(int[] arr : list) {
                result[pos] = arr;
                pos++;
            }
        }
        
        return result;
    }
}