class Solution {
    public long largestPerimeter(int[] nums) {
        long peri = 0;
        Arrays.sort(nums);
        for(int n : nums){
            peri += n;
        }
        int l = nums.length;
        for(int i = l-1; i >= 2; i--){
            peri -= nums[i];
            if(peri > nums[i]){
                return peri + nums[i];
            }
        }
        return -1;
    }
}