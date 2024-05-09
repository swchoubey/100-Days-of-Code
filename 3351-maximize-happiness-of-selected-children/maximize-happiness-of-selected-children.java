class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long result = 0;
        int n = happiness.length, j = 0;
        for(int i = n - 1; i >= n - k; --i){
            happiness[i] = Math.max(happiness[i] - j++, 0);
            result += happiness[i];
        }

        return result;
    }
}