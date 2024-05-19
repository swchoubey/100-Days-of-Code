class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long total = 0;
        for(int n : nums){
            total += n;
        }
        long totalDiff = 0;
        long diff;
        int posCount = 0;
        long minAbsDiff = Long.MAX_VALUE;

        for(int n : nums){
            diff = (n ^ k) - n;

            if(diff > 0){
                totalDiff += diff;
                posCount++;
            }

            minAbsDiff = Math.min(minAbsDiff, Math.abs(diff));
        }
        if(posCount % 2 == 1){
            totalDiff -= minAbsDiff;
        }

        return total + totalDiff;
    }
}