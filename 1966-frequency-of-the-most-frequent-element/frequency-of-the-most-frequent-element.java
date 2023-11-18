class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int sum=0;
        int window=0;
        int p=0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            while((i-p+1) * nums[i] - sum > k){
                sum -= nums[p];
                p++;
            }
            window = Math.max(window, i-p+1);
        }
        return window;
    }
}