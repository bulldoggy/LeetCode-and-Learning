/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int min = Integer.MAX_VALUE;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
          
            if(isBadVersion(mid)) {
                min = Math.min(min, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return min;
    }
}