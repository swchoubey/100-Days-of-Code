class Solution {
    public int minSwaps(int[] nums) {
        int k = Arrays.stream(nums).sum();
        int n = nums.length;
        int c = 0;
        for(int i = 0; i < k; ++i){
            c += nums[i];
        }
        int max = c;
        for(int i = k; i < n + k; ++i){
            c += nums[i % n] - nums[(i - k + n) % n];
            max = Math.max(max, c);
        }

        return k - max;
    }
}