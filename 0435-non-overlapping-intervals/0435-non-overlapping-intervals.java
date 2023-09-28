class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        int end = -50001;
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        for(int[] interval : intervals) {
            if(end <= interval[0]) {
                end = interval[1];
            } else {
                result++;
                end = Math.min(end, interval[1]);
            }
        }
        
        return result;
    }
}