import java.math.BigInteger;

class Solution {
    public int numberOfWays(String corridor) {
        List<Integer> plantsList = new ArrayList<>();
        final BigInteger modulo = BigInteger.valueOf(1000000007);
        int start = corridor.indexOf('S');
        int end = corridor.lastIndexOf('S');
        int plantsCount = 0;
        
        for(int i = start + 1; i <= end; i++) {
            if(corridor.charAt(i) == 'S') {
                plantsList.add(plantsCount);
                plantsCount = 0;
            } else {
                plantsCount++;
            }
        }
        
        if(plantsList.size() % 2 == 0) {
            return 0;
        }
        
        BigInteger numWays = BigInteger.ONE;
        
        for(int i = 1; i < plantsList.size(); i += 2) {
                numWays = numWays.multiply(BigInteger.valueOf(plantsList.get(i) + 1));
        }
        
        return numWays.mod(modulo).intValue();
    }
}