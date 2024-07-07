class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int n = 0;
        while(numBottles >= numExchange){
            n+=numExchange;
            numBottles-=numExchange;
            numBottles++;
        }
        return n + numBottles;
    }
}