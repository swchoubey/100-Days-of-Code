class Solution {
    public int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = 0;i<prices.length; i++){
            profit=Math.max(profit, prices[i]-lowest);
            lowest=Math.min(lowest, prices[i]);
        }
        return profit;
    }
}