class Solution {
    public int minDifference(int[] nums) {
        if(nums.length <= 4) return 0;
        Arrays.sort(nums);

        int k = nums.length - 3;

        int res = nums[nums.length - 1] - nums[0];

        for(int i = k - 1; i < nums.length; i++){
            res = Math.min(res, nums[i] - nums[i - k + 1]);
        }

        return res;
    }
}