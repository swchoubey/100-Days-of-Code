class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int b = -1, l = -1, r = -1;

        for(int i = 0; i < nums.length; ++i){
            if(!(minK <= nums[i] && nums[i] <= maxK))
                b = i;
            
            if(nums[i] == minK)
                l = i;

            if(nums[i] == maxK)
                r = i;

            res += Math.max(0, Math.min(l, r) - b);
        }

        return res;
    }
}