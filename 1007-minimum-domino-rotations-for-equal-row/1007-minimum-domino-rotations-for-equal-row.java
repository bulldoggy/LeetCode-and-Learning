class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer, Integer> top = new HashMap<>();
        HashMap<Integer, Integer> bottom = new HashMap<>();
        HashMap<Integer, Integer> extra = new HashMap<>();
        
        for(int i = 1; i <= 6; i++) {
            top.put(i, 0);
            bottom.put(i, 0);
            extra.put(i, 0);
        }
        
        for(int i = 0; i < tops.length; i++) {
            if(tops[i] == bottoms[i]) extra.put(tops[i], extra.get(tops[i]) + 1);
            else {
                top.put(tops[i], top.get(tops[i]) + 1);
                bottom.put(bottoms[i], bottom.get(bottoms[i]) + 1);
            }
        }
        
        int dots = 1;
        int maxNum = 0;
        boolean topHasMore = false;
        
        while(maxNum == 0 && dots <= 6) {
            if(top.get(dots) + bottom.get(dots) + extra.get(dots) >= tops.length) {
                maxNum = dots;
                if(top.get(dots) > bottom.get(dots)) topHasMore = true;
            }
            dots++;
        }

        if(maxNum == 0) return -1;
        
        if(topHasMore) {
            return tops.length - top.get(maxNum) - extra.get(maxNum);
        }        
        return tops.length - bottom.get(maxNum) - extra.get(maxNum);
    }
}