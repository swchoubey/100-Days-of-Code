class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int res = 0;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for(int i = 0; i < n; ++i){
            dp[i] = new HashMap<>();
        }
        for(int i = 1; i < n; ++i){
            for(int j = 0; j < i; ++j){
                long diff = (long) nums[i] - nums[j];

                if(diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE){
                    continue;
                }

                int intD = (int) diff;
                dp[i].put(intD, dp[i].getOrDefault(intD, 0) + 1);
                if(dp[j].containsKey(intD)){
                    dp[i].put(intD, dp[i].get(intD) + dp[j].get(intD));
                    res+=dp[j].get(intD);
                }
            }
        }
        return res;
    }
}