class Solution {
    public int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int totalProfit = 0;
        int currProfit = 0;
        for(int i = 0; i< prices.length; i++){
            if(prices[i]<lowest){
                lowest = prices[i];
            }
            currProfit = prices[i]-lowest;
            if(totalProfit < currProfit){
                totalProfit = currProfit;
            }
        }
        return totalProfit;
    }
}