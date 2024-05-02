class Solution {
    public int findMaxK(int[] nums) {
        int maxK = 0;
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while(l < r){
            if(nums[l] * -1 == nums[r]){
                maxK = Math.max(maxK, nums[r]);
                l++;
                r--;
            }
            else if(Math.abs(nums[l]) > nums[r]){
                l++;
            }
            else{
                r--;
            }

        }

        return maxK == 0 ? -1 : maxK;
    }
}