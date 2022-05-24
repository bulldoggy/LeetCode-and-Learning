class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int lowest = 10000;
        
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < lowest) {
                lowest = prices[i];
            } 
            
            if(prices[i] - lowest > profit) {
                profit = prices[i] - lowest;
            }
        }
        
        return profit;
    }
}